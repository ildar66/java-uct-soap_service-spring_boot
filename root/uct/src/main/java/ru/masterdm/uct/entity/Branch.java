package ru.masterdm.uct.entity;

import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Branch entity class.
 */
@XmlType(propOrder={"branchId", "branchBIC", "branchName", "branchNameFull"})
public class Branch {
    private Long branchId; //ID организации
    private Long branchBIC; // БИК подразделения Банка
    private String branchName; // Название подразделения Банка
    private String branchNameFull; // Полное название подразделения Банка

    /**
     * Default constructor.
     */
    public Branch() { }

    /**
     * branchId field getter.
     * @return branchId
     */
    @XmlElement(name = "BRANCHID", nillable = true)
    public Long getBranchId() {
        return branchId;
    }

    /**
     * branchId field setter.
     * @param branchId branchId
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    /**
     * branchBic field getter.
     * @return branchBic
     */
    @XmlElement(name = "BIC", nillable = true)
    public Long getBranchBIC() {
        return branchBIC;
    }

    /**
     * branchBic field setter.
     * @param branchBIC branchBic
     */
    public void setBranchBIC(Long branchBIC) {
        this.branchBIC = branchBIC;
    }

    /**
     * branchName field getter.
     * @return branchName
     */
    @XmlElement(name = "NAMESHORT", nillable = true)
    public String getBranchName() {
        return branchName;
    }

    /**
     * branchName field setter.
     * @param branchName branchName
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * branchNameFull field getter.
     * @return branchNameFull
     */
    @XmlElement(name = "NAMEFULL", nillable = true)
    public String getBranchNameFull() {
        return branchNameFull;
    }

    /**
     * branchNameFull field setter.
     * @param branchNameFull branchNameFull
     */
    public void setBranchNameFull(String branchNameFull) {
        this.branchNameFull = branchNameFull;
    }
}
