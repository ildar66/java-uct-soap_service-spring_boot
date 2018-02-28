package ru.masterdm.uct.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Statement document class.
 * Using for XML output.
 * @author Ildar Shafigullin
 */
@XmlRootElement(name = "Statement")
@XmlType(propOrder = {"custId", "account", "type", "statementDate", "statementDoc"})
public class StatementDoc {

    private String account; // счет, по которому нужно получить выписку
    private int type; // тип запроса: 0 – выписка, 1-справка.
    private String signData; // Данные ЭЦП
    private Date statementDate; // Дата выписки
    private Long custId; // ID организации
    private String statementDoc; // Данные выписки

    /**
     * Default constructor.
     */
    public StatementDoc() {
    }

    /**
     * Returns statement account.
     * @return account
     */
    @XmlElement(name = "Account")
    public String getAccount() {
        return account;
    }

    /**
     * Sets account for statement.
     * @param account statement
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Returns statement type.
     * @return type statement
     */
    @XmlElement(name = "StatementType")
    public int getType() {
        return type;
    }

    /**
     * Sets statement type.
     * @param type statement
     */
    public void setType(int type) {
        this.type = type;
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

    /**
     * Returns statement Date.
     * @return statement Date
     */
    @XmlElement(name = "StatementDate")
    public Date getStatementDate() {
        return statementDate;
    }

    /**
     * Sets statement Date.
     * @param statementDate statement Date
     */
    public void setStatementDate(Date statementDate) {
        this.statementDate = statementDate;
    }

    /**
     * Returns cust Id.
     * @return custId
     */
    @XmlElement(name = "CustID")
    public Long getCustId() {
        return custId;
    }

    /**
     * Sets customer Id.
     * @param custId customer Id
     */
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    /**
     * Returns statement Document.
     * @return statementDoc statement Document
     */
    @XmlElement(name = "StatementDoc")
    public String getStatementDoc() {
        return statementDoc;
    }

    /**
     * Sets statement Document.
     * @param statementDoc statement Document
     */
    public void setStatementDoc(String statementDoc) {
        this.statementDoc = statementDoc;
    }

    @Override
    public String toString() {
        return "StatementDoc{" +
               "account='" + account + '\'' +
               ", type=" + type +
               ", signData='" + signData + '\'' +
               ", statementDate=" + statementDate +
               ", custId=" + custId +
               '}';
    }
}
