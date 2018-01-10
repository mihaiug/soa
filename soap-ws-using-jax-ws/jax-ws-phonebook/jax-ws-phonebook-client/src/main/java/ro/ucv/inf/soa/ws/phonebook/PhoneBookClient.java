package ro.ucv.inf.soa.ws.phonebook;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;

import ro.ucv.inf.soa.ws.phonebook.service.Contact;
import ro.ucv.inf.soa.ws.phonebook.service.ContactService;
import ro.ucv.inf.soa.ws.phonebook.service.Contacts;

public class PhoneBookClient {
  public static void main(String[] args) throws Exception {
    
    URL wsdlLocation = new URL("http://localhost:8080/jax-ws-phonebook/contacts?wsdl");
    QName serviceName = new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "contacts");
    
    Contacts contacts = new Contacts(wsdlLocation, serviceName);
    ContactService contactService = contacts.getContactServiceImplPort();
   
    //Add a contact to PhoneBook
    Contact contact = new Contact();
    contact.setName("Mihai");
    contact.setPhone("1234");
    System.out.println("Add contact: " + contact);
    contactService.addContact(contact);
    
    //Gets all contacts.
    List<Contact> contactsList = contactService.getAllContacts();
    
    System.out.println("Get contacts: " +contactsList);
  }
}
