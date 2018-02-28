package ru.masterdm.uct.entity;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Account entity class.
 */

public class Account {

    private Customer customer;
    private Branch branch;
    private BigDecimal rest;
    private String ln;
    private String account;

    /**
     * customer field getter.
     * @return customer
     */
    @XmlTransient
    public Customer getCustomer() {
        return customer;
    }

    /**
     * customer field setter.
     * @param customer customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * branch field getter.
     * @return branch
     */
    @XmlTransient
    public Branch getBranch() {
        return branch;
    }

    /**
     * branch field setter.
     * @param branch branch
     */
    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    /**
     * Returns rest field getter for xml.
     * @return rest
     */
    @XmlElement(name = "Rest")
    public String getRestMarshal() {
        return getRest().setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }

    /**
     * rest field getter.
     * @return rest
     */
    @XmlTransient
    public BigDecimal getRest() {
        return rest == null ? BigDecimal.ZERO : rest;
    }

    /**
     * rest field setter.
     * @param rest rest
     */
    public void setRest(BigDecimal rest) {
        this.rest = rest;
    }

    /**
     * ln field getter.
     * @return ln
     */
    public String getLn() {
        return ln;
    }

    /**
     * ln field setter.
     * @param ln ln
     */
    public void setLn(String ln) {
        this.ln = ln;
    }

    /**
     * account field getter.
     * @return account
     */
    @XmlElement(name = "Acc")
    public String getAccount() {
        return account;
    }

    /**
     * account field setter.
     * @param account account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * customer's id getter.
     * @return customer's id
     */
    @XmlElement(name = "CustId")
    public Long getCustomerId() {
        return customer != null ? customer.getCustId() : null;
    }

    /**
     * customer's name getter.
     * @return customer's name
     */
    @XmlElement(name = "CustomerName")
    public String getCustomerName() {
        return customer != null ? customer.getNameFull() : null;
    }

    /**
     * branch's id getter.
     * @return branch's id
     */
    @XmlElement(name = "BranchID")
    public Long getBranchId() {
        return branch != null ? branch.getBranchId() : null;
    }

    /**
     * branch's bic getter.
     * @return branch's bic
     */
    @XmlElement(name = "BranchBIC")
    public Long getBranchBic() {
        return branch != null ? branch.getBranchBIC() : null;
    }

    /**
     * branch's name getter.
     * @return branch's name
     */
    @XmlElement(name = "BranchName")
    public String getBranchName() {
        return branch != null ? branch.getBranchName() : null;
    }
}