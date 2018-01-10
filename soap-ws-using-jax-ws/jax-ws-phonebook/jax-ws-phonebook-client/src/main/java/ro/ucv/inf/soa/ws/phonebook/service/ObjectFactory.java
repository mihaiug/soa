
package ro.ucv.inf.soa.ws.phonebook.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ro.ucv.inf.soa.ws.phonebook.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddContact_QNAME = new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "addContact");
    private final static QName _AddContactResponse_QNAME = new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "addContactResponse");
    private final static QName _DeleteContact_QNAME = new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "deleteContact");
    private final static QName _DeleteContactResponse_QNAME = new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "deleteContactResponse");
    private final static QName _GetAllContacts_QNAME = new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "getAllContacts");
    private final static QName _GetAllContactsResponse_QNAME = new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "getAllContactsResponse");
    private final static QName _GetContactById_QNAME = new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "getContactById");
    private final static QName _GetContactByIdResponse_QNAME = new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "getContactByIdResponse");
    private final static QName _UpdateContact_QNAME = new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "updateContact");
    private final static QName _UpdateContactResponse_QNAME = new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "updateContactResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ro.ucv.inf.soa.ws.phonebook.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddContact }
     * 
     */
    public AddContact createAddContact() {
        return new AddContact();
    }

    /**
     * Create an instance of {@link AddContactResponse }
     * 
     */
    public AddContactResponse createAddContactResponse() {
        return new AddContactResponse();
    }

    /**
     * Create an instance of {@link DeleteContact }
     * 
     */
    public DeleteContact createDeleteContact() {
        return new DeleteContact();
    }

    /**
     * Create an instance of {@link DeleteContactResponse }
     * 
     */
    public DeleteContactResponse createDeleteContactResponse() {
        return new DeleteContactResponse();
    }

    /**
     * Create an instance of {@link GetAllContacts }
     * 
     */
    public GetAllContacts createGetAllContacts() {
        return new GetAllContacts();
    }

    /**
     * Create an instance of {@link GetAllContactsResponse }
     * 
     */
    public GetAllContactsResponse createGetAllContactsResponse() {
        return new GetAllContactsResponse();
    }

    /**
     * Create an instance of {@link GetContactById }
     * 
     */
    public GetContactById createGetContactById() {
        return new GetContactById();
    }

    /**
     * Create an instance of {@link GetContactByIdResponse }
     * 
     */
    public GetContactByIdResponse createGetContactByIdResponse() {
        return new GetContactByIdResponse();
    }

    /**
     * Create an instance of {@link UpdateContact }
     * 
     */
    public UpdateContact createUpdateContact() {
        return new UpdateContact();
    }

    /**
     * Create an instance of {@link UpdateContactResponse }
     * 
     */
    public UpdateContactResponse createUpdateContactResponse() {
        return new UpdateContactResponse();
    }

    /**
     * Create an instance of {@link Contact }
     * 
     */
    public Contact createContact() {
        return new Contact();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddContact }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddContact }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", name = "addContact")
    public JAXBElement<AddContact> createAddContact(AddContact value) {
        return new JAXBElement<AddContact>(_AddContact_QNAME, AddContact.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddContactResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddContactResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", name = "addContactResponse")
    public JAXBElement<AddContactResponse> createAddContactResponse(AddContactResponse value) {
        return new JAXBElement<AddContactResponse>(_AddContactResponse_QNAME, AddContactResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteContact }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteContact }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", name = "deleteContact")
    public JAXBElement<DeleteContact> createDeleteContact(DeleteContact value) {
        return new JAXBElement<DeleteContact>(_DeleteContact_QNAME, DeleteContact.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteContactResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteContactResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", name = "deleteContactResponse")
    public JAXBElement<DeleteContactResponse> createDeleteContactResponse(DeleteContactResponse value) {
        return new JAXBElement<DeleteContactResponse>(_DeleteContactResponse_QNAME, DeleteContactResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllContacts }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllContacts }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", name = "getAllContacts")
    public JAXBElement<GetAllContacts> createGetAllContacts(GetAllContacts value) {
        return new JAXBElement<GetAllContacts>(_GetAllContacts_QNAME, GetAllContacts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllContactsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllContactsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", name = "getAllContactsResponse")
    public JAXBElement<GetAllContactsResponse> createGetAllContactsResponse(GetAllContactsResponse value) {
        return new JAXBElement<GetAllContactsResponse>(_GetAllContactsResponse_QNAME, GetAllContactsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContactById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetContactById }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", name = "getContactById")
    public JAXBElement<GetContactById> createGetContactById(GetContactById value) {
        return new JAXBElement<GetContactById>(_GetContactById_QNAME, GetContactById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContactByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetContactByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", name = "getContactByIdResponse")
    public JAXBElement<GetContactByIdResponse> createGetContactByIdResponse(GetContactByIdResponse value) {
        return new JAXBElement<GetContactByIdResponse>(_GetContactByIdResponse_QNAME, GetContactByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateContact }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateContact }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", name = "updateContact")
    public JAXBElement<UpdateContact> createUpdateContact(UpdateContact value) {
        return new JAXBElement<UpdateContact>(_UpdateContact_QNAME, UpdateContact.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateContactResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateContactResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", name = "updateContactResponse")
    public JAXBElement<UpdateContactResponse> createUpdateContactResponse(UpdateContactResponse value) {
        return new JAXBElement<UpdateContactResponse>(_UpdateContactResponse_QNAME, UpdateContactResponse.class, null, value);
    }

}
