//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.21 at 02:11:26 PM EDT 
//

package com.gtnexus.appxpress.platform.module.model.design;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}enabled"/>
 *         &lt;element ref="{}navHeading"/>
 *         &lt;element ref="{}landingOQL"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "enabled", "navHeading", "landingOQL" })
@XmlRootElement(name = "navFeature")
public class NavFeature {

    protected boolean enabled;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String navHeading;
    @XmlElement(required = true)
    protected String landingOQL;

    /**
     * Gets the value of the enabled property.
     * 
     */
    public boolean isEnabled() {
	return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     */
    public void setEnabled(boolean value) {
	this.enabled = value;
    }

    /**
     * Gets the value of the navHeading property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getNavHeading() {
	return navHeading;
    }

    /**
     * Sets the value of the navHeading property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setNavHeading(String value) {
	this.navHeading = value;
    }

    /**
     * Gets the value of the landingOQL property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getLandingOQL() {
	return landingOQL;
    }

    /**
     * Sets the value of the landingOQL property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setLandingOQL(String value) {
	this.landingOQL = value;
    }

}