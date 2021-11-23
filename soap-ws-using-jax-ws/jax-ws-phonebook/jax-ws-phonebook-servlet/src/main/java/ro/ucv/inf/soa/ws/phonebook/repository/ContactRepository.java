package ro.ucv.inf.soa.ws.phonebook.repository;

import java.util.List;

import ro.ucv.inf.soa.ws.phonebook.model.Contact;

public interface ContactRepository {
  
  /**
   * Find a contact with specified id.
   * 
   * @param id The contact Id.
   * @return The contact with specified id or <code>null</code> if contact not found.
   */ 
  public Contact findOne(Long id);

  /**
   * Find a contact by name.
   * 
   * @param name The name to be searched.
   * @return The founded contact or <code>null</code> if contact not found.
   */ 
  public Contact findByName(String name);

  /**
   * Find a contact by phone.
   * 
   * @param phone The phone number to be searched.
   * @return The founded contact or <code>null</code> if contact not found.
   */ 
  public Contact findByPhone(String phone);
  
  /**
   * Gets the list of contacts from phonebook.
   * 
   * @return A list containing the phonebook contacts.
   */
  public List<Contact> findAll();

  /**
   * Add or update a contact.
   * 
   * @param contact The contact to be added or updated. If contact id is <code>null</code> then the contact is added, otherwise contact is updated.
   * 
   * @return The added contact.
   */
  public Contact save(Contact contact);

  /**
   * Delete contact with specified id.
   * 
   * @param id The contact Id.
   */
  public void delete(Long id);
}
