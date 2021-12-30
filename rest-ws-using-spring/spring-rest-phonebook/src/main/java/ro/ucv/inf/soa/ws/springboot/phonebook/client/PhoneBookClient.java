package ro.ucv.inf.soa.ws.springboot.phonebook.client;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ro.ucv.inf.soa.ws.springboot.phonebook.model.Contact;

public class PhoneBookClient {
  public static void main(String[] args) {
    String apiURL = "http://localhost:8080/rest-phonebook/api/contacts";

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    // Find contacts containing a specified string
    String name = "Mihai";
    ResponseEntity<Contact[]> findResponse = restTemplate.getForEntity(apiURL + "?name={name}", Contact[].class, name);

    boolean found = false;
    if (findResponse.getStatusCode() == HttpStatus.OK) {
      Contact contacts[] = findResponse.getBody();

      if (contacts.length > 0) {
        found = true;
        System.out.println("Contacts containing " + name);
        for (Contact contact : contacts) {
          System.out.println(contact);
        }
      }
    }
    
    Long addedContactId = null;
    if (!found) {
      // Add a contact
      Contact contactToAdd = new Contact();
      contactToAdd.setName(name);
      contactToAdd.setPhone("7123456789");
      System.out.println("Add contact " + contactToAdd);

      HttpEntity<Contact> entity = new HttpEntity<Contact>(contactToAdd, httpHeaders);
      ResponseEntity<Contact> addResponse = restTemplate.postForEntity(apiURL, entity, Contact.class);

      System.out.println("Added response: " + addResponse);
      addedContactId = addResponse.getBody().getId();
    }

    //Get a contact by id
    Long id = new Long(1);
    ResponseEntity<Contact> response = restTemplate.getForEntity(apiURL + "/{id}", Contact.class, id);
    System.out.println("Get contact: " + response.getBody());

    //Get all contacts 
    System.out.println("Get all contacts");
    ResponseEntity<Contact[]> contactsResponse = restTemplate.getForEntity(apiURL, Contact[].class);
    if (contactsResponse.hasBody()) {
      for (Contact contact : contactsResponse.getBody()) {
        System.out.println(contact);
      }
    }

    if (addedContactId != null) {      
      System.out.println("Delete Contact with id: " + addedContactId);
      restTemplate.delete(apiURL + "/{id}", addedContactId);
    }
  }
}
