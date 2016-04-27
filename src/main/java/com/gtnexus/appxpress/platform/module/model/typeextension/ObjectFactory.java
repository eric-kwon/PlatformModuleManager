//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.26 at 06:23:51 PM PDT 
//


package com.gtnexus.appxpress.platform.module.model.typeextension;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the platform.module.model.typeextension package. 
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

    private final static QName _Uid_QNAME = new QName("", "uid");
    private final static QName _ApiVersion_QNAME = new QName("", "apiVersion");
    private final static QName _DocumentType_QNAME = new QName("", "documentType");
    private final static QName _Status_QNAME = new QName("", "status");
    private final static QName _CreatorId_QNAME = new QName("", "creatorId");
    private final static QName _UserModRev_QNAME = new QName("", "userModRev");
    private final static QName _Type_QNAME = new QName("", "type");
    private final static QName _PlatformModuleId_QNAME = new QName("", "platformModuleId");
    private final static QName _ModifyTimestamp_QNAME = new QName("", "modifyTimestamp");
    private final static QName _CreateTimestamp_QNAME = new QName("", "createTimestamp");
    private final static QName _Fingerprint_QNAME = new QName("", "fingerprint");
    private final static QName _PlatformModuleType_QNAME = new QName("", "platformModuleType");
    private final static QName _Rank_QNAME = new QName("", "rank");
    private final static QName _Event_QNAME = new QName("", "event");
    private final static QName _Role_QNAME = new QName("", "role");
    private final static QName _FunctionName_QNAME = new QName("", "functionName");
    private final static QName _RedirectUrl_QNAME = new QName("", "redirectUrl");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: platform.module.model.typeextension
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TypeExtensionD1 }
     * 
     */
    public TypeExtensionD1 createTYPEEXTENSIOND1() {
        return new TypeExtensionD1();
    }

    /**
     * Create an instance of {@link Metadata }
     * 
     */
    public Metadata createMetadata() {
        return new Metadata();
    }

    /**
     * Create an instance of {@link Callbacks }
     * 
     */
    public Callbacks createCallbacks() {
        return new Callbacks();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "uid")
    public JAXBElement<BigInteger> createUid(BigInteger value) {
        return new JAXBElement<BigInteger>(_Uid_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "apiVersion")
    public JAXBElement<BigInteger> createApiVersion(BigInteger value) {
        return new JAXBElement<BigInteger>(_ApiVersion_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "documentType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createDocumentType(String value) {
        return new JAXBElement<String>(_DocumentType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "status")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "creatorId")
    public JAXBElement<BigInteger> createCreatorId(BigInteger value) {
        return new JAXBElement<BigInteger>(_CreatorId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "userModRev")
    public JAXBElement<BigInteger> createUserModRev(BigInteger value) {
        return new JAXBElement<BigInteger>(_UserModRev_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "type")
    public JAXBElement<String> createType(String value) {
        return new JAXBElement<String>(_Type_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "platformModuleId")
    public JAXBElement<BigInteger> createPlatformModuleId(BigInteger value) {
        return new JAXBElement<BigInteger>(_PlatformModuleId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "modifyTimestamp")
    public JAXBElement<String> createModifyTimestamp(String value) {
        return new JAXBElement<String>(_ModifyTimestamp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "createTimestamp")
    public JAXBElement<String> createCreateTimestamp(String value) {
        return new JAXBElement<String>(_CreateTimestamp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fingerprint")
    public JAXBElement<String> createFingerprint(String value) {
        return new JAXBElement<String>(_Fingerprint_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "platformModuleType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createPlatformModuleType(String value) {
        return new JAXBElement<String>(_PlatformModuleType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rank")
    public JAXBElement<BigInteger> createRank(BigInteger value) {
        return new JAXBElement<BigInteger>(_Rank_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "event")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createEvent(String value) {
        return new JAXBElement<String>(_Event_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "role")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createRole(String value) {
        return new JAXBElement<String>(_Role_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "functionName")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createFunctionName(String value) {
        return new JAXBElement<String>(_FunctionName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "redirectUrl")
    public JAXBElement<String> createRedirectUrl(String value) {
        return new JAXBElement<String>(_RedirectUrl_QNAME, String.class, null, value);
    }

}
