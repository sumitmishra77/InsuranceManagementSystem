
package my.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the my.services package. 
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

    private final static QName _ApprovedClaimCountResponse_QNAME = new QName("http://services.my/", "approvedClaimCountResponse");
    private final static QName _AddClaimResponse_QNAME = new QName("http://services.my/", "addClaimResponse");
    private final static QName _GetAllClaim_QNAME = new QName("http://services.my/", "getAllClaim");
    private final static QName _GetAllClaimResponse_QNAME = new QName("http://services.my/", "getAllClaimResponse");
    private final static QName _GetClaim_QNAME = new QName("http://services.my/", "getClaim");
    private final static QName _CanClaim_QNAME = new QName("http://services.my/", "canClaim");
    private final static QName _UpdateStatusResponse_QNAME = new QName("http://services.my/", "updateStatusResponse");
    private final static QName _ApprovedClaimCount_QNAME = new QName("http://services.my/", "approvedClaimCount");
    private final static QName _CanClaimResponse_QNAME = new QName("http://services.my/", "canClaimResponse");
    private final static QName _GetClaimResponse_QNAME = new QName("http://services.my/", "getClaimResponse");
    private final static QName _GetClaimByID_QNAME = new QName("http://services.my/", "getClaimByID");
    private final static QName _UpdateStatus_QNAME = new QName("http://services.my/", "updateStatus");
    private final static QName _GetClaimByIDResponse_QNAME = new QName("http://services.my/", "getClaimByIDResponse");
    private final static QName _AddClaim_QNAME = new QName("http://services.my/", "addClaim");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: my.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateStatusResponse }
     * 
     */
    public UpdateStatusResponse createUpdateStatusResponse() {
        return new UpdateStatusResponse();
    }

    /**
     * Create an instance of {@link CanClaim }
     * 
     */
    public CanClaim createCanClaim() {
        return new CanClaim();
    }

    /**
     * Create an instance of {@link GetAllClaimResponse }
     * 
     */
    public GetAllClaimResponse createGetAllClaimResponse() {
        return new GetAllClaimResponse();
    }

    /**
     * Create an instance of {@link GetClaim }
     * 
     */
    public GetClaim createGetClaim() {
        return new GetClaim();
    }

    /**
     * Create an instance of {@link AddClaimResponse }
     * 
     */
    public AddClaimResponse createAddClaimResponse() {
        return new AddClaimResponse();
    }

    /**
     * Create an instance of {@link GetAllClaim }
     * 
     */
    public GetAllClaim createGetAllClaim() {
        return new GetAllClaim();
    }

    /**
     * Create an instance of {@link ApprovedClaimCountResponse }
     * 
     */
    public ApprovedClaimCountResponse createApprovedClaimCountResponse() {
        return new ApprovedClaimCountResponse();
    }

    /**
     * Create an instance of {@link GetClaimByIDResponse }
     * 
     */
    public GetClaimByIDResponse createGetClaimByIDResponse() {
        return new GetClaimByIDResponse();
    }

    /**
     * Create an instance of {@link AddClaim }
     * 
     */
    public AddClaim createAddClaim() {
        return new AddClaim();
    }

    /**
     * Create an instance of {@link GetClaimByID }
     * 
     */
    public GetClaimByID createGetClaimByID() {
        return new GetClaimByID();
    }

    /**
     * Create an instance of {@link UpdateStatus }
     * 
     */
    public UpdateStatus createUpdateStatus() {
        return new UpdateStatus();
    }

    /**
     * Create an instance of {@link ApprovedClaimCount }
     * 
     */
    public ApprovedClaimCount createApprovedClaimCount() {
        return new ApprovedClaimCount();
    }

    /**
     * Create an instance of {@link CanClaimResponse }
     * 
     */
    public CanClaimResponse createCanClaimResponse() {
        return new CanClaimResponse();
    }

    /**
     * Create an instance of {@link GetClaimResponse }
     * 
     */
    public GetClaimResponse createGetClaimResponse() {
        return new GetClaimResponse();
    }

    /**
     * Create an instance of {@link Claim }
     * 
     */
    public Claim createClaim() {
        return new Claim();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovedClaimCountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "approvedClaimCountResponse")
    public JAXBElement<ApprovedClaimCountResponse> createApprovedClaimCountResponse(ApprovedClaimCountResponse value) {
        return new JAXBElement<ApprovedClaimCountResponse>(_ApprovedClaimCountResponse_QNAME, ApprovedClaimCountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddClaimResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "addClaimResponse")
    public JAXBElement<AddClaimResponse> createAddClaimResponse(AddClaimResponse value) {
        return new JAXBElement<AddClaimResponse>(_AddClaimResponse_QNAME, AddClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllClaim }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "getAllClaim")
    public JAXBElement<GetAllClaim> createGetAllClaim(GetAllClaim value) {
        return new JAXBElement<GetAllClaim>(_GetAllClaim_QNAME, GetAllClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllClaimResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "getAllClaimResponse")
    public JAXBElement<GetAllClaimResponse> createGetAllClaimResponse(GetAllClaimResponse value) {
        return new JAXBElement<GetAllClaimResponse>(_GetAllClaimResponse_QNAME, GetAllClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClaim }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "getClaim")
    public JAXBElement<GetClaim> createGetClaim(GetClaim value) {
        return new JAXBElement<GetClaim>(_GetClaim_QNAME, GetClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CanClaim }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "canClaim")
    public JAXBElement<CanClaim> createCanClaim(CanClaim value) {
        return new JAXBElement<CanClaim>(_CanClaim_QNAME, CanClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "updateStatusResponse")
    public JAXBElement<UpdateStatusResponse> createUpdateStatusResponse(UpdateStatusResponse value) {
        return new JAXBElement<UpdateStatusResponse>(_UpdateStatusResponse_QNAME, UpdateStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApprovedClaimCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "approvedClaimCount")
    public JAXBElement<ApprovedClaimCount> createApprovedClaimCount(ApprovedClaimCount value) {
        return new JAXBElement<ApprovedClaimCount>(_ApprovedClaimCount_QNAME, ApprovedClaimCount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CanClaimResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "canClaimResponse")
    public JAXBElement<CanClaimResponse> createCanClaimResponse(CanClaimResponse value) {
        return new JAXBElement<CanClaimResponse>(_CanClaimResponse_QNAME, CanClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClaimResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "getClaimResponse")
    public JAXBElement<GetClaimResponse> createGetClaimResponse(GetClaimResponse value) {
        return new JAXBElement<GetClaimResponse>(_GetClaimResponse_QNAME, GetClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClaimByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "getClaimByID")
    public JAXBElement<GetClaimByID> createGetClaimByID(GetClaimByID value) {
        return new JAXBElement<GetClaimByID>(_GetClaimByID_QNAME, GetClaimByID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "updateStatus")
    public JAXBElement<UpdateStatus> createUpdateStatus(UpdateStatus value) {
        return new JAXBElement<UpdateStatus>(_UpdateStatus_QNAME, UpdateStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClaimByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "getClaimByIDResponse")
    public JAXBElement<GetClaimByIDResponse> createGetClaimByIDResponse(GetClaimByIDResponse value) {
        return new JAXBElement<GetClaimByIDResponse>(_GetClaimByIDResponse_QNAME, GetClaimByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddClaim }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.my/", name = "addClaim")
    public JAXBElement<AddClaim> createAddClaim(AddClaim value) {
        return new JAXBElement<AddClaim>(_AddClaim_QNAME, AddClaim.class, null, value);
    }

}
