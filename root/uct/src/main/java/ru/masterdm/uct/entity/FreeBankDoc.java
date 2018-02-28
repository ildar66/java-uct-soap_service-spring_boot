package ru.masterdm.uct.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Free bank document entity class.
 * Using for XML output.
 * @author Ildar Shafigullin
 */
@XmlRootElement(name = "Doc")
@XmlType(propOrder = {"recordID", "documentDate", "docType", "docName", "docBody"})
public class FreeBankDoc {

    private String recordID;
    private Date documentDate;
    private String docType;
    private String docName;
    private String docBody;
    private String signData;

    /**
     * Returns record ID.
     * @return recordID
     */
    @XmlElement(name = "RecordID")
    public String getRecordID() {
        return recordID;
    }

    /**
     * Sets record ID.
     * @param recordID record ID
     */
    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    /**
     * Returns document Date.
     * @return documentDate
     */
    @XmlElement(name = "DocumentDate")
    public Date getDocumentDate() {
        return documentDate;
    }

    /**
     * Sets document Date.
     * @param documentDate document Date
     */
    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    /**
     * Returns document type.
     * @return docType
     */
    @XmlElement(name = "DocType")
    public String getDocType() {
        return docType;
    }

    /**
     * Sets document type.
     * @param docType document type
     */
    public void setDocType(String docType) {
        this.docType = docType;
    }

    /**
     * Returns document Name.
     * @return docName
     */
    @XmlElement(name = "DocName")
    public String getDocName() {
        return docName;
    }

    /**
     * Sets document Name.
     * @param docName document name
     */
    public void setDocName(String docName) {
        this.docName = docName;
    }

    /**
     * Returns document.
     * @return docBody document
     */
    @XmlElement(name = "DocBody")
    public String getDocBody() {
        return docBody;
    }

    /**
     * Sets document body.
     * @param docBody document body
     */
    public void setDocBody(String docBody) {
        this.docBody = docBody;
    }

    /**
     * Returns sign Data.
     * @return signData sign Data
     */
    @XmlTransient
    public String getSignData() {
        return signData;
    }

    /**
     * Sets sign Data.
     * @param signData sign Data
     */
    public void setSignData(String signData) {
        this.signData = signData;
    }

    @Override
    public String toString() {
        return "FreeBankDoc{" +
               "recordID='" + recordID + '\'' +
               ", documentDate=" + documentDate +
               ", docType='" + docType + '\'' +
               ", docName='" + docName + '\'' +
               '}';
    }
}
