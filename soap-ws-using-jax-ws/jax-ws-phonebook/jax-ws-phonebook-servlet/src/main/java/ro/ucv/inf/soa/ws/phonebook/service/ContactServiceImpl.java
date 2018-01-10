package ro.ucv.inf.soa.ws.phonebook.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import ro.ucv.inf.soa.ws.phonebook.exception.RecordNotFoundException;
import ro.ucv.inf.soa.ws.phonebook.model.Contact;
import ro.ucv.inf.soa.ws.phonebook.repository.ContactRepository;
import ro.ucv.inf.soa.ws.phonebook.repository.ContactRepositoryMemImpl;


@WebService(serviceName="contacts", endpointInterface="ro.ucv.inf.soa.ws.phonebook.service.ContactService")
public class ContactServiceImpl implements ContactService {

  private ContactRepository contactRepository;

  public ContactServiceImpl() {
    contactRepository = new ContactRepositoryMemImpl();
  }

  @WebMethod
  @Override
  public List<Contact> getAllContacts() {
    return contactRepository.findAll();
  }

  @Override
  public Contact getContactById(@WebParam(name="id") @XmlElement(required=true, nillable=false)  Long id) throws RecordNotFoundException {
    Contact contact = contactRepository.findOne(id);
    if (contact == null) {
      throw new RecordNotFoundException("Not found contact with id: " + id);
    }
    return contact;
  }

  @Override
  public void addContact(@WebParam(name="contact") Contact contact) {
    contact.setId(null);
    contactRepository.save(contact);
  }

  @Override
  public void updateContact(@WebParam(name="contact")  Contact contact) throws RecordNotFoundException {
    contactRepository.save(contact);
  }

  @Override
  public void deleteContact(@WebParam(name="id") @XmlElement(required=true, nillable=false) Long id) throws RecordNotFoundException {

    contactRepository.delete(id);
  }

  public static void main(String[] args) {

  }

}
