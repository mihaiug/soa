package ro.ucv.inf.soa.ws.springboot.phonebook.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ucv.inf.soa.ws.springboot.phonebook.exception.DuplicateRecordException;
import ro.ucv.inf.soa.ws.springboot.phonebook.exception.RecordNotFoundException;
import ro.ucv.inf.soa.ws.springboot.phonebook.model.Contact;
import ro.ucv.inf.soa.ws.springboot.phonebook.repository.ContactRepository;
import ro.ucv.inf.soa.ws.springboot.phonebook.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

  private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

  @Autowired
  private ContactRepository contactRepository;

  @Override
  public Contact findContact(Long contactId) {
    return contactRepository.findById(contactId).orElse(null);
  }

  @Override
  public List<Contact> findContacts(String name) {
    return contactRepository.findByNameContaining(name);
  }

  @Override
  public List<Contact> findAllContacts() {
    return contactRepository.findAll();
  }

  @Override
  @Transactional
  public Contact add(Contact contact) {
    // Check if already exist a contact with same email.
    Contact existingContact = contactRepository.findByPhone(contact.getPhone());
    if (existingContact != null) {
      String errorMessage = "Already exists a contact with same phone: " + contact.getPhone();
      logger.error(errorMessage);
      throw new DuplicateRecordException(errorMessage);
    }
    contact.setId(null); //Remove id because will be generated.
    contactRepository.save(contact);
    return contact;
  }

  @Override
  @Transactional
  public Contact update(Contact contact) {
    Contact existingContact = contactRepository.findById(contact.getId()).orElse(null);
    if (existingContact == null) {
      String errorMessage = "Contact with id " + contact.getId() + " not found";
      logger.error(errorMessage);
      throw new RecordNotFoundException(errorMessage);
    }

    // Check if phone was changed.
    if (!existingContact.getPhone().equals(contact.getPhone())) {
      // Phone changed, check again if new phone already exists.
      if (contactRepository.findByPhone(contact.getPhone()) != null) {
        String errorMessage = "The new phone already used by other contact: " + contact.getPhone();
        logger.error(errorMessage);
        throw new DuplicateRecordException(errorMessage);
      }
    }

    return contactRepository.save(contact);
  }

  @Override
  @Transactional
  public void delete(Long contactId) {
    Contact contact = contactRepository.findById(contactId).orElse(null);
    logger.debug("Delete contact with id: " + contactId);
    if (contact != null) {
      contactRepository.delete(contact);
    } else {
      String errorMessage = "Contact with id " + contactId + " not found";
      logger.error(errorMessage);
      throw new RecordNotFoundException(errorMessage);
    }
  }
}
