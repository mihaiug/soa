
package ro.ucv.inf.soa.ws.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ro.ucv.inf.soa.ws.service package. 
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

    private final static QName _Sum_QNAME = new QName("http://service.ws.soa.inf.ucv.ro/", "sum");
    private final static QName _Diference_QNAME = new QName("http://service.ws.soa.inf.ucv.ro/", "diference");
    private final static QName _DiferenceResponse_QNAME = new QName("http://service.ws.soa.inf.ucv.ro/", "diferenceResponse");
    private final static QName _SumResponse_QNAME = new QName("http://service.ws.soa.inf.ucv.ro/", "sumResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ro.ucv.inf.soa.ws.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Diference }
     * 
     */
    public Diference createDiference() {
        return new Diference();
    }

    /**
     * Create an instance of {@link Sum }
     * 
     */
    public Sum createSum() {
        return new Sum();
    }

    /**
     * Create an instance of {@link DiferenceResponse }
     * 
     */
    public DiferenceResponse createDiferenceResponse() {
        return new DiferenceResponse();
    }

    /**
     * Create an instance of {@link SumResponse }
     * 
     */
    public SumResponse createSumResponse() {
        return new SumResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.soa.inf.ucv.ro/", name = "sum")
    public JAXBElement<Sum> createSum(Sum value) {
        return new JAXBElement<Sum>(_Sum_QNAME, Sum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Diference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.soa.inf.ucv.ro/", name = "diference")
    public JAXBElement<Diference> createDiference(Diference value) {
        return new JAXBElement<Diference>(_Diference_QNAME, Diference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiferenceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.soa.inf.ucv.ro/", name = "diferenceResponse")
    public JAXBElement<DiferenceResponse> createDiferenceResponse(DiferenceResponse value) {
        return new JAXBElement<DiferenceResponse>(_DiferenceResponse_QNAME, DiferenceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.soa.inf.ucv.ro/", name = "sumResponse")
    public JAXBElement<SumResponse> createSumResponse(SumResponse value) {
        return new JAXBElement<SumResponse>(_SumResponse_QNAME, SumResponse.class, null, value);
    }

}
