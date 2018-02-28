package ru.masterdm.uct.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Customer entity type.
 */
@XmlRootElement(name = "Customer")
@XmlType(propOrder={"client", "custId", "customerType", "fiscalReasonCode", "inn",
                    "intAddress", "intPlace", "intState", "intZip",
                    "lawAddress", "lawCountry", "lawPlace", "lawPlaceType", "lawState", "lawZip",
                    "nameFull", "nameInt", "nameShort", "okatoCode", "okpoCode", "propertyType",
                    "lawDistrict", "lawCity", "lawStreet", "lawBuilding", "lawBlock", "lawOffice", "uctBranches"})
public class Customer {

    private Long custId; // ID организации
    private Integer client; // Уникальный идентификатор комплекса
    private Integer customerType; // Тип организации
    private String fiscalReasonCode; // КПП
    private String inn; // ИНН
    private String intAddress; // Международный Адрес
    private String intPlace; // Международный : Населенный пункт
    private String intState; // Международный : Субъект РФ/ штат
    private String intZip; //Международный Индекс
    private String lawAddress; // Адрес
    private String lawCountry; // Код страны
    private String lawPlace; // Населенный пункт
    private Integer lawPlaceType; // Тип населенного пункта (из справочника PlaceType )
    private String lawState; // Субъект РФ/ штат
    private String lawZip; // Индекс
    private String nameFull; // Полное название
    private String nameInt; // Международное название
    private String nameShort; // Название в фин. документах
    private String okatoCode; // Код ОКАТО
    private String okpoCode; // Код ОКПО
    private Integer propertyType; //  Форма собственности (из справочника PropertyType)
    private String lawDistrict; // Район
    private String lawCity; // Город
    private String lawStreet; // Улица
    private String lawBuilding; // Номер дома / владение
    private String lawBlock; // Корпус / строение
    private String lawOffice; // Офис / квартира
    private Branches branches = new Branches();

    /**
     * custId field getter.
     * @return custId
     */
    @XmlElement(name = "CUSTID", nillable = true)
    public Long getCustId() {
        return custId;
    }

    /**
     * custId field setter.
     * @param custId custdId
     */
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    /**
     * client field getter.
     * @return client
     */
    @XmlElement(name = "CLIENT", nillable = true)
    public Integer getClient() {
        return client;
    }

    /**
     * client field setter.
     * @param client client
     */
    public void setClient(Integer client) {
        this.client = client;
    }

    /**
     * customerType field getter.
     * @return customerType
     */
    @XmlElement(name = "CUSTOMERTYPE", nillable = true)
    public Integer getCustomerType() {
        return customerType;
    }

    /**
     * customerType field setter.
     * @param customerType customerType
     */
    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    /**
     * fiscalReasonCode field getter.
     * @return fiscalReasonCode
     */
    @XmlElement(name = "FISCALREASONCODE", nillable = true)
    public String getFiscalReasonCode() {
        return fiscalReasonCode;
    }

    /**
     * fiscalReasonCode field setter.
     * @param fiscalReasonCode fiscalReasonCode
     */
    public void setFiscalReasonCode(String fiscalReasonCode) {
        this.fiscalReasonCode = fiscalReasonCode;
    }

    /**
     * inn field getter.
     * @return inn
     */
    @XmlElement(name = "INN", nillable = true)
    public String getInn() {
        return inn;
    }

    /**
     * inn field setter.
     * @param inn inn
     */
    public void setInn(String inn) {
        this.inn = inn;
    }

    /**
     * intAddress field getter.
     * @return intAddress
     */
    @XmlElement(name = "INTADDRESS", nillable = true)
    public String getIntAddress() {
        return intAddress;
    }

    /**
     * intAddress field setter.
     * @param intAddress intAddress
     */
    public void setIntAddress(String intAddress) {
        this.intAddress = intAddress;
    }

    /**
     * intPlace field getter.
     * @return intPlace
     */
    @XmlElement(name = "INTPLACE", nillable = true)
    public String getIntPlace() {
        return intPlace;
    }

    /**
     * intPlace field setter.
     * @param intPlace intPlace
     */
    public void setIntPlace(String intPlace) {
        this.intPlace = intPlace;
    }

    /**
     * intState field getter.
     * @return intState
     */
    @XmlElement(name = "INTSTATE", nillable = true)
    public String getIntState() {
        return intState;
    }

    /**
     * intState field setter.
     * @param intState intState
     */
    public void setIntState(String intState) {
        this.intState = intState;
    }

    /**
     * intZip field getter.
     * @return intZip
     */
    @XmlElement(name = "INTZIP", nillable = true)
    public String getIntZip() {
        return intZip;
    }

    /**
     * intZip field setter.
     * @param intZip intZip
     */
    public void setIntZip(String intZip) {
        this.intZip = intZip;
    }

    /**
     * lawAddress field getter.
     * @return lawAddress
     */
    @XmlElement(name = "LAWADDRESS", nillable = true)
    public String getLawAddress() {
        return lawAddress;
    }

    /**
     * lawAddress field setter.
     * @param lawAddress lawAddress
     */
    public void setLawAddress(String lawAddress) {
        this.lawAddress = lawAddress;
    }

    /**
     * lawCountry field getter.
     * @return lawCountry
     */
    @XmlElement(name = "LAWCOUNTRY", nillable = true)
    public String getLawCountry() {
        return lawCountry;
    }

    /**
     * lawCountry field setter.
     * @param lawCountry lawCountry
     */
    public void setLawCountry(String lawCountry) {
        this.lawCountry = lawCountry;
    }

    /**
     * lawPlace field getter.
     * @return lawPlace
     */
    @XmlElement(name = "LAWPLACE", nillable = true)
    public String getLawPlace() {
        return lawPlace;
    }

    /**
     * lawPlace field setter.
     * @param lawPlace lawPlace
     */
    public void setLawPlace(String lawPlace) {
        this.lawPlace = lawPlace;
    }

    /**
     * lawPlaceType field getter.
     * @return lawPlaceType
     */
    @XmlElement(name = "LAWPLACETYPE", nillable = true)
    public Integer getLawPlaceType() {
        return lawPlaceType;
    }

    /**
     * lawPlaceType field setter.
     * @param lawPlaceType lawPlaceType
     */
    public void setLawPlaceType(Integer lawPlaceType) {
        this.lawPlaceType = lawPlaceType;
    }

    /**
     * lawState field getter.
     * @return lawState
     */
    @XmlElement(name = "LAWSTATE", nillable = true)
    public String getLawState() {
        return lawState;
    }

    /**
     * lawState field setter.
     * @param lawState lawState
     */
    public void setLawState(String lawState) {
        this.lawState = lawState;
    }

    /**
     * lawZip field getter.
     * @return lawZip
     */
    @XmlElement(name = "LAWZIP", nillable = true)
    public String getLawZip() {
        return lawZip;
    }

    /**
     * lawZip field setter.
     * @param lawZip lawZip
     */
    public void setLawZip(String lawZip) {
        this.lawZip = lawZip;
    }

    /**
     * nameFull field getter.
     * @return nameFull
     */
    @XmlElement(name = "NAMEFULL", nillable = true)
    public String getNameFull() {
        return nameFull;
    }

    /**
     * nameFull field setter.
     * @param nameFull nameFull
     */
    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    /**
     * nameInt field getter.
     * @return nameInt
     */
    @XmlElement(name = "NAMEINT", nillable = true)
    public String getNameInt() {
        return nameInt;
    }

    /**
     * nameInt field setter.
     * @param nameInt nameInt
     */
    public void setNameInt(String nameInt) {
        this.nameInt = nameInt;
    }

    /**
     * nameShort field getter.
     * @return nameShort
     */
    @XmlElement(name = "NAMESHORT", nillable = true)
    public String getNameShort() {
        return nameShort;
    }

    /**
     * nameShort field setter.
     * @param nameShort nameShort
     */
    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    /**
     * okatoCode field getter.
     * @return okatoCode
     */
    @XmlElement(name = "OKATOCODE", nillable = true)
    public String getOkatoCode() {
        return okatoCode;
    }

    /**
     * okatoCode field setter.
     * @param okatoCode okatoCode
     */
    public void setOkatoCode(String okatoCode) {
        this.okatoCode = okatoCode;
    }

    /**
     * okpoCode field getter.
     * @return okpoCode
     */
    @XmlElement(name = "OKPOCODE", nillable = true)
    public String getOkpoCode() {
        return okpoCode;
    }

    /**
     * okpoCode field setter.
     * @param okpoCode okpoCode
     */
    public void setOkpoCode(String okpoCode) {
        this.okpoCode = okpoCode;
    }

    /**
     * propertyType field getter.
     * @return propertyType
     */
    @XmlElement(name = "PROPERTYTYPE", nillable = true)
    public Integer getPropertyType() {
        return propertyType;
    }

    /**
     * propertyType field setter.
     * @param propertyType propertyType
     */
    public void setPropertyType(Integer propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * lawDistrict field getter.
     * @return lawDistrict
     */
    @XmlElement(name = "LAWDISTRICT", nillable = true)
    public String getLawDistrict() {
        return lawDistrict;
    }

    /**
     * lawDistrict field setter.
     * @param lawDistrict lawDistrict
     */
    public void setLawDistrict(String lawDistrict) {
        this.lawDistrict = lawDistrict;
    }

    /**
     * lawCity field getter.
     * @return lawCity
     */
    @XmlElement(name = "LAWCITY", nillable = true)
    public String getLawCity() {
        return lawCity;
    }

    /**
     * lawCity field setter.
     * @param lawCity lawCity
     */
    public void setLawCity(String lawCity) {
        this.lawCity = lawCity;
    }

    /**
     * lawStreet field getter.
     * @return lawStreet
     */
    @XmlElement(name = "LAWSTREET", nillable = true)
    public String getLawStreet() {
        return lawStreet;
    }

    /**
     * lawStreet field setter.
     * @param lawStreet lawStreet
     */
    public void setLawStreet(String lawStreet) {
        this.lawStreet = lawStreet;
    }

    /**
     * lawBuilding field getter.
     * @return lawBuilding
     */
    @XmlElement(name = "LAWBUILDING", nillable = true)
    public String getLawBuilding() {
        return lawBuilding;
    }

    /**
     * lawBuilding field setter.
     * @param lawBuilding lawBuilding
     */
    public void setLawBuilding(String lawBuilding) {
        this.lawBuilding = lawBuilding;
    }

    /**
     * lawBlock field getter.
     * @return lawBlock
     */
    @XmlElement(name = "LAWBLOCK", nillable = true)
    public String getLawBlock() {
        return lawBlock;
    }

    /**
     * lawBlock field setter.
     * @param lawBlock lawBlock
     */
    public void setLawBlock(String lawBlock) {
        this.lawBlock = lawBlock;
    }

    /**
     * lawOffice field getter.
     * @return lawOffice
     */
    @XmlElement(name = "LAWOFFICE", nillable = true)
    public String getLawOffice() {
        return lawOffice;
    }

    /**
     * lawOffice field setter.
     * @param lawOffice lawOffice
     */
    public void setLawOffice(String lawOffice) {
        this.lawOffice = lawOffice;
    }

    /**
     * branches field getter for xml.
     * @return branches
     */
    @XmlElement(name = "Branches", nillable = true)
    public Branches getUctBranches() {
        return branches;
    }

    /**
     * branches field getter.
     * @return branches
     */
    @XmlTransient
    public List<Branch> getBranches() {
        return branches.getBranches();
    }

    /**
     * branches field setter.
     * @param branches branches
     */
    public void setBranches(List<Branch> branches) {
        this.branches = new Branches(branches);
    }
}
