
package ro.ucv.inf.soa.ws.phonebook.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.7
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ContactService", targetNamespace = "http://service.phonebook.ws.soa.inf.ucv.ro/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ContactService {


    /**
     * 
     * @return
     *     returns java.util.List<ro.ucv.inf.soa.ws.phonebook.service.Contact>
     */
    @WebMethod
    @WebResult(name = "Contact", targetNamespace = "")
    @RequestWrapper(localName = "getAllContacts", targetNamespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", className = "ro.ucv.inf.soa.ws.phonebook.service.GetAllContacts")
    @ResponseWrapper(localName = "getAllContactsResponse", targetNamespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", className = "ro.ucv.inf.soa.ws.phonebook.service.GetAllContactsResponse")
    @Action(input = "http://service.phonebook.ws.soa.inf.ucv.ro/ContactService/getAllContactsRequest", output = "http://service.phonebook.ws.soa.inf.ucv.ro/ContactService/getAllContactsResponse")
    public List<Contact> getAllContacts();

    /**
     * 
     * @param id
     * @return
     *     returns ro.ucv.inf.soa.ws.phonebook.service.Contact
     */
    @WebMethod
    @WebResult(name = "Contact", targetNamespace = "")
    @RequestWrapper(localName = "getContactById", targetNamespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", className = "ro.ucv.inf.soa.ws.phonebook.service.GetContactById")
    @ResponseWrapper(localName = "getContactByIdResponse", targetNamespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", className = "ro.ucv.inf.soa.ws.phonebook.service.GetContactByIdResponse")
    @Action(input = "http://service.phonebook.ws.soa.inf.ucv.ro/ContactService/getContactByIdRequest", output = "http://service.phonebook.ws.soa.inf.ucv.ro/ContactService/getContactByIdResponse")
    public Contact getContactById(
        @WebParam(name = "id", targetNamespace = "")
        long id);

    /**
     * 
     * @param contact
     */
    @WebMethod
    @RequestWrapper(localName = "addContact", targetNamespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", className = "ro.ucv.inf.soa.ws.phonebook.service.AddContact")
    @ResponseWrapper(localName = "addContactResponse", targetNamespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", className = "ro.ucv.inf.soa.ws.phonebook.service.AddContactResponse")
    @Action(input = "http://service.phonebook.ws.soa.inf.ucv.ro/ContactService/addContactRequest", output = "http://service.phonebook.ws.soa.inf.ucv.ro/ContactService/addContactResponse")
    public void addContact(
        @WebParam(name = "contact", targetNamespace = "")
        Contact contact);

    /**
     * 
     * @param contact
     */
    @WebMethod
    @RequestWrapper(localName = "updateContact", targetNamespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", className = "ro.ucv.inf.soa.ws.phonebook.service.UpdateContact")
    @ResponseWrapper(localName = "updateContactResponse", targetNamespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", className = "ro.ucv.inf.soa.ws.phonebook.service.UpdateContactResponse")
    @Action(input = "http://service.phonebook.ws.soa.inf.ucv.ro/ContactService/updateContactRequest", output = "http://service.phonebook.ws.soa.inf.ucv.ro/ContactService/updateContactResponse")
    public void updateContact(
        @WebParam(name = "contact", targetNamespace = "")
        Contact contact);

    /**
     * 
     * @param id
     */
    @WebMethod
    @RequestWrapper(localName = "deleteContact", targetNamespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", className = "ro.ucv.inf.soa.ws.phonebook.service.DeleteContact")
    @ResponseWrapper(localName = "deleteContactResponse", targetNamespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", className = "ro.ucv.inf.soa.ws.phonebook.service.DeleteContactResponse")
    @Action(input = "http://service.phonebook.ws.soa.inf.ucv.ro/ContactService/deleteContactRequest", output = "http://service.phonebook.ws.soa.inf.ucv.ro/ContactService/deleteContactResponse")
    public void deleteContact(
        @WebParam(name = "id", targetNamespace = "")
        long id);

}
