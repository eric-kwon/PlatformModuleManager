//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.27 at 10:43:26 AM EDT 
//

package com.gtnexus.appxpress.platform.module.model.template;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
 *         &lt;element ref="{}description"/>
 *         &lt;element ref="{}templateName"/>
 *         &lt;element ref="{}dataMarkupType"/>
 *         &lt;element ref="{}renderMarkupType"/>
 *         &lt;element ref="{}memo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "description", "templateName", "dataMarkupType", "renderMarkupType", "memo" })
@XmlRootElement(name = "TemplateMediaV110")
public class TemplateMediaV110 {

    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String templateName;
    @XmlElement(required = true)
    protected String dataMarkupType;
    @XmlElement(required = true)
    protected String renderMarkupType;
    @XmlElement(required = true)
    protected String memo;

    /**
     * Gets the value of the description property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getDescription() {
	return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setDescription(String value) {
	this.description = value;
    }

    /**
     * Gets the value of the templateName property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getTemplateName() {
	return templateName;
    }

    /**
     * Sets the value of the templateName property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setTemplateName(String value) {
	this.templateName = value;
    }

    /**
     * Gets the value of the dataMarkupType property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getDataMarkupType() {
	return dataMarkupType;
    }

    /**
     * Sets the value of the dataMarkupType property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setDataMarkupType(String value) {
	this.dataMarkupType = value;
    }

    /**
     * Gets the value of the renderMarkupType property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getRenderMarkupType() {
	return renderMarkupType;
    }

    /**
     * Sets the value of the renderMarkupType property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setRenderMarkupType(String value) {
	this.renderMarkupType = value;
    }

    /**
     * Gets the value of the memo property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getMemo() {
	return memo;
    }

    /**
     * Sets the value of the memo property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setMemo(String value) {
	this.memo = value;
    }

}
