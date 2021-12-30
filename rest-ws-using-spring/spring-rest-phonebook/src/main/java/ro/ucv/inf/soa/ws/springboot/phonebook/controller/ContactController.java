package ro.ucv.inf.soa.ws.springboot.phonebook.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import ro.ucv.inf.soa.ws.springboot.phonebook.exception.RecordNotFoundException;
import ro.ucv.inf.soa.ws.springboot.phonebook.model.Contact;
import ro.ucv.inf.soa.ws.springboot.phonebook.service.ContactService;

@RestController
@RequestMapping(value = "/api")
public class ContactController {

  private final Logger logger = LoggerFactory.getLogger(ContactController.class);

  @Autowired
  private ContactService contactService;

  /**
   * Get contacts list.
   * 
   * @param name The 'name' filter.
   * 
   * @return A list contacts containing the <code>name</code>,
   *         all contacts otherwise if <code>name</code> is <code>null</code>.
   */
  @RequestMapping(value = "/contacts", method = RequestMethod.GET, 
      produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public List<Contact> getContacts(@RequestParam(required = false) String name) {
    if (name == null) {
      return contactService.findAllContacts();
    } else {
      return contactService.findContacts(name);
    }
  }

  /**
   * Get the contact with specified id.
   * 
   * @param contactId The contact id.
   * @return The contact with specified id.
   * @throws RecordNotFoundException If contact not found.
   */
  @GetMapping(value = "/contacts/{id}",
      produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public Contact getContact(@PathVariable("id") Long contactId) throws RecordNotFoundException {
    Contact contact = contactService.findContact(contactId);
    if (contact != null) {
      return contact;
    } else {
      String errorMessage = "Not found contact with id " + contactId;
      logger.error(errorMessage);
      throw new RecordNotFoundException(errorMessage);
    }
  }

  /**
   * Handling POST request for add contact in database.
   * It also validates the contact input.
   */
  @PostMapping(value = "/contacts", 
      consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
      produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<Contact> addContact(@Valid @RequestBody Contact contact, UriComponentsBuilder uriComponentsBuilder) {
    contact = contactService.add(contact);
    // Build link to obtain the added contact. This will be sent in 'Location' header.
    UriComponents uriComponents = uriComponentsBuilder.path("/contacts/{id}").buildAndExpand(contact.getId());

    return ResponseEntity.created(uriComponents.toUri()).body(contact);
  }

  /**
   * Handle PUT request for update a contact.
   * 
   * @param id      The contact id.
   * @param contact The new contact.
   */
  @PutMapping(value = "/contacts/{id}", 
      consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  public ResponseEntity<?> updateContact(@PathVariable("id") Long id,
      @Valid @RequestBody Contact contact) {
    contact.setId(id);
    contactService.update(contact);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Handle DELETE request for delete a contact.
   * 
   * @param id The contact id.
   */
  @DeleteMapping(value = "/contacts/{id}")
  public void deleteContact(@PathVariable("id") Long id) {
    contactService.delete(id);
  }

}