package ro.ucv.inf.soa.ws.phonebook.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import ro.ucv.inf.soa.ws.phonebook.exception.RecordNotFoundException;
import ro.ucv.inf.soa.ws.phonebook.model.Contact;

/**
 * In Memory Contacts Repository Implementation.
 */
public class ContactRepositoryMemImpl implements ContactRepository {

  /**
   * Keep the list of contacts.
   */
  private List<Contact> contacts = new LinkedList<Contact>();

  /**
   * The last contact id. It is used to generate unique ids.
   */
  private AtomicLong lastContactId = new AtomicLong(0);

  /**
   * Find a contact with specified id.
   * 
   * @param id  The contact Id.
   * @return The contact with specified id or <code>null</code> if contact not
   *         found.
   */
  public Contact findOne(Long id) {
    Contact contact = null;
    for (Contact currentContact : contacts) {
      if (currentContact.getId() == id) {
        contact = currentContact;
        break;
      }
    }

    return contact;
  }

  @Override
  public Contact findByName(String name) {
    Contact contact = null;
    for (Contact currentContact : contacts) {
      if (currentContact.getName().equalsIgnoreCase(name)) {
        contact = currentContact;
        break;
      }
    }

    return contact;
  }

  @Override
  public List<Contact> findAll() {
    return contacts;
  }

  @Override
  public Contact save(Contact contact) {
    if (contact.getId() == null) {
      // Add contact if id is null.
      contact.setId(getNextContactId());
      contacts.add(contact);
    } else {
      // Update contact.
      Contact existingContact = findOne(contact.getId());
      if (existingContact != null) {
        existingContact.setName(contact.getName());
        existingContact.setPhone(contact.getPhone());
      } else {
        throw new RecordNotFoundException("Not found contact with id: " + contact.getId());
      }
    }
    return contact;
  }

  @Override
  public void delete(Long id) {
    Contact existingContact = findOne(id);
    if (existingContact != null) {
      contacts.remove(existingContact);
    } else {
      throw new RecordNotFoundException("Not found contact with id: " + id);
    }

  }

  /**
   * Provide a unique contact ID.
   * 
   * @return A new contact ID.
   */
  private long getNextContactId() {
    return lastContactId.incrementAndGet();
  }
}
