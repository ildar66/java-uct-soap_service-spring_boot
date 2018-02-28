package ru.masterdm.uct.entity;

/**
 * Certificate entity class.
 * @author Ildar Shafigullin
 */
public class Certificate {

    private String serialNumber; // Серийный номер
    private String subject; // Владелец
    private String issuer; // Издатель
    private String subjectAltname; // Имя владельца
    private String notesAddress; // LN-имя

    /**
     * Returns serial number.
     * @return serialNumber serial number
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets serial number.
     * @param serialNumber serial number
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Returns subject.
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     * @param subject subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Returns issuer.
     * @return issuer issuer
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Sets issuer.
     * @param issuer issuer
     */
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    /**
     * Returns subject Name.
     * @return subjectAltname
     */
    public String getSubjectAltname() {
        return subjectAltname;
    }

    /**
     * Sets subject name.
     * @param subjectAltname subject name
     */
    public void setSubjectAltname(String subjectAltname) {
        this.subjectAltname = subjectAltname;
    }

    /**
     * Returns notes Address.
     * @return notesAddress notes address
     */
    public String getNotesAddress() {
        return notesAddress;
    }

    /**
     * Sets notes Address.
     * @param notesAddress notes address
     */
    public void setNotesAddress(String notesAddress) {
        this.notesAddress = notesAddress;
    }

    @Override
    public String toString() {
        return "Certificate{" +
               "serialNumber='" + serialNumber + '\'' +
               ", subject='" + subject + '\'' +
               ", issuer='" + issuer + '\'' +
               ", subjectAltname='" + subjectAltname + '\'' +
               ", notesAddress='" + notesAddress + '\'' +
               '}';
    }
}
