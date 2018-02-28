package ru.masterdm.uct.entity;

import java.util.Date;

/**
 * Document entity class.
 */
public class Document {

    private String docData;
    private String docScheme;
    private int docVersion;
    private int custID;
    private String signData;
    private String recordID;
    private String remoteUser;
    private String docStatus;
    private String docInfo;
    private Date documentDate;
    private String cancelFields;
    private String bsErrorCode;
    private String bsError;

    /**
     * Default constructor.
     */
    public Document() {
    }

    /**
     * Constructor with all fields.
     * @param docData xml document
     * @param docScheme xsd scheme name
     * @param docVersion xsd scheme version
     * @param custID customer id
     * @param signData signature
     * @param remoteUser remote user
     */
    public Document(String docData, String docScheme, int docVersion, int custID, String signData, String remoteUser) {
        this.docData = docData;
        this.docScheme = docScheme;
        this.docVersion = docVersion;
        this.custID = custID;
        this.signData = signData;
        this.remoteUser = remoteUser;
    }

    /**
     * docData field getter.
     * @return docData
     */
    public String getDocData() {
        return docData;
    }

    /**
     * docData field setter.
     * @param docData xml document
     */
    public void setDocData(String docData) {
        this.docData = docData;
    }

    /**
     * docScheme field getter.
     * @return docScheme
     */
    public String getDocScheme() {
        return docScheme;
    }

    /**
     * docScheme field setter.
     * @param docScheme xsd scheme
     */
    public void setDocScheme(String docScheme) {
        this.docScheme = docScheme;
    }

    /**
     * docVersion field getter.
     * @return docVersion
     */
    public int getDocVersion() {
        return docVersion;
    }

    /**
     * docVersion field setter.
     * @param docVersion xsd scheme version
     */
    public void setDocVersion(int docVersion) {
        this.docVersion = docVersion;
    }

    /**
     * custID field getter.
     * @return custID
     */
    public int getCustID() {
        return custID;
    }

    /**
     * custID field setter.
     * @param custID customer id
     */
    public void setCustID(int custID) {
        this.custID = custID;
    }

    /**
     * signData field getter.
     * @return signData
     */
    public String getSignData() {
        return signData;
    }

    /**
     * signData field setter.
     * @param signData signature
     */
    public void setSignData(String signData) {
        this.signData = signData;
    }

    /**
     * recordID field getter.
     * @return recordID
     */
    public String getRecordID() {
        return recordID;
    }

    /**
     * recordID field setter.
     * @param recordID record id
     */
    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    /**
     * remoteUser field getter.
     * @return remoteUser
     */
    public String getRemoteUser() {
        return remoteUser;
    }

    /**
     * remoteUser field setter.
     * @param remoteUser remote user
     */
    public void setRemoteUser(String remoteUser) {
        this.remoteUser = remoteUser;
    }

    /**
     * docStatus field getter.
     * @return docStatus
     */
    public String getDocStatus() {
        return docStatus;
    }

    /**
     * docStatus field setter.
     * @param docStatus document status
     */
    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    /**
     * Returns docInfo.
     * @return docInfo doc Info
     */
    public String getDocInfo() {
        return docInfo;
    }

    /**
     * Sets docInfo.
     * @param docInfo doc Info
     */
    public void setDocInfo(String docInfo) {
        this.docInfo = docInfo;
    }

    /**
     * Returns document date.
     * @return documentDate document date
     */
    public Date getDocumentDate() {
        return documentDate;
    }

    /**
     * Sets document date.
     * @param documentDate document date
     */
    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    /**
     * Returns cancel Fields for document.
     * @return cancelFields cancel fields
     */
    public String getCancelFields() {
        return cancelFields;
    }

    /**
     * Sets cancel Fields for document.
     * @param cancelFields cancel fields
     */
    public void setCancelFields(String cancelFields) {
        this.cancelFields = cancelFields;
    }

    /**
     * Returns bsError Code.
     * @return bsErrorCode bsError Code
     */
    public String getBsErrorCode() {
        return bsErrorCode;
    }

    /**
     * Sets bsError Code.
     * @param bsErrorCode bsError Code
     */
    public void setBsErrorCode(String bsErrorCode) {
        this.bsErrorCode = bsErrorCode;
    }

    /**
     * Returns bs Error.
     * @return bsError bs Error
     */
    public String getBsError() {
        return bsError;
    }

    /**
     * Sets bs Error.
     * @param bsError bs Error
     */
    public void setBsError(String bsError) {
        this.bsError = bsError;
    }

    @Override
    public String toString() {
        return "Document{" +
               "docData='" + docData + '\'' +
               ", docScheme='" + docScheme + '\'' +
               ", docVersion=" + docVersion +
               ", custID=" + custID +
               ", signData='" + signData + '\'' +
               ", recordID='" + recordID + '\'' +
               ", remoteUser='" + remoteUser + '\'' +
               ", docStatus='" + docStatus + '\'' +
               ", docInfo='" + docInfo + '\'' +
               ", documentDate=" + documentDate +
               ", cancelFields='" + cancelFields + '\'' +
               '}';
    }
}
