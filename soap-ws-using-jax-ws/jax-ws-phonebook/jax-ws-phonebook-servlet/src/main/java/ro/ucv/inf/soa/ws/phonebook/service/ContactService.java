package ro.ucv.inf.soa.ws.phonebook.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import ro.ucv.inf.soa.ws.phonebook.exception.DuplicateRecordException;
import ro.ucv.inf.soa.ws.phonebook.exception.RecordNotFoundException;
import ro.ucv.inf.soa.ws.phonebook.model.Contact;

@WebService
public interface ContactService {

  @WebResult(name = "Contact")
  List<Contact> getAllContacts();

  @WebResult(name = "Contact")
  Contact getContactById(@WebParam(name = "id", mode=Mode.IN) @XmlElement(required = true, nillable = false) Long id) throws RecordNotFoundException;

  void addContact(@WebParam(name = "contact") @XmlElement(required = true, nillable = false) Contact contact) throws DuplicateRecordException;

  void updateContact(@WebParam(name = "contact") @XmlElement(required = true, nillable = false) Contact contact) throws RecordNotFoundException;

  void deleteContact(@WebParam(name = "id") @XmlElement(required = true, nillable = false) Long id) throws RecordNotFoundException;

}