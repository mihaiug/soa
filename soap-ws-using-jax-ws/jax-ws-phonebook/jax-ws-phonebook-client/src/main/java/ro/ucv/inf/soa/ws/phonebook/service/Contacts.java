
package ro.ucv.inf.soa.ws.phonebook.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.7
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "contacts", targetNamespace = "http://service.phonebook.ws.soa.inf.ucv.ro/", wsdlLocation = "http://localhost:8080/jax-ws-phonebook/contacts?wsdl")
public class Contacts
    extends Service
{

    private static final URL CONTACTS_WSDL_LOCATION;
    private static final WebServiceException CONTACTS_EXCEPTION;
    private static final QName CONTACTS_QNAME = new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "contacts");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/jax-ws-phonebook/contacts?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONTACTS_WSDL_LOCATION = url;
        CONTACTS_EXCEPTION = e;
    }

    public Contacts() {
        super(__getWsdlLocation(), CONTACTS_QNAME);
    }

    public Contacts(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONTACTS_QNAME, features);
    }

    public Contacts(URL wsdlLocation) {
        super(wsdlLocation, CONTACTS_QNAME);
    }

    public Contacts(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONTACTS_QNAME, features);
    }

    public Contacts(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Contacts(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ContactService
     */
    @WebEndpoint(name = "ContactServiceImplPort")
    public ContactService getContactServiceImplPort() {
        return super.getPort(new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "ContactServiceImplPort"), ContactService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ContactService
     */
    @WebEndpoint(name = "ContactServiceImplPort")
    public ContactService getContactServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.phonebook.ws.soa.inf.ucv.ro/", "ContactServiceImplPort"), ContactService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONTACTS_EXCEPTION!= null) {
            throw CONTACTS_EXCEPTION;
        }
        return CONTACTS_WSDL_LOCATION;
    }

}
