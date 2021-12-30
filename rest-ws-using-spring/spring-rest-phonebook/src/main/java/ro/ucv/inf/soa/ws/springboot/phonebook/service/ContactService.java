package ro.ucv.inf.soa.ws.springboot.phonebook.service;

import java.util.List;

import ro.ucv.inf.soa.ws.springboot.phonebook.model.Contact;

public interface ContactService {
  public Contact findContact(Long contactId);

  public List<Contact> findContacts(String name);

  public List<Contact> findAllContacts();

  public Contact add(Contact contact);

  public Contact update(Contact contact);

  public void delete(Long contactId);
}
