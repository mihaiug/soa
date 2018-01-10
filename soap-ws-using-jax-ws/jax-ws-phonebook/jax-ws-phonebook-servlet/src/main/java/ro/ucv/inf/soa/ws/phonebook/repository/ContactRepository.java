package ro.ucv.inf.soa.ws.phonebook.repository;

import java.util.List;

import ro.ucv.inf.soa.ws.phonebook.model.Contact;

public interface ContactRepository {
   
  public Contact findOne(Long id);

  public Contact findByName(String name);

  public List<Contact> findAll();

  public Contact save(Contact contact);

  public void delete(Long id);

}
