package ru.masterdm.uct.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Customers for marshalling.
 */
@XmlRootElement(name = "Customers")
public class Customers {
    private List<Customer> customers = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Customers() { }

    /**
     * Constructor with customers.
     * @param customers customers
     */
    public Customers(List<Customer> customers) {
        this.customers = customers;
    }

    /**
     * customers field getter.
     * @return customers
     */
    @XmlElement(name = "Customer")
    public List<Customer> getCustomers() {
        return customers;
    }
}
