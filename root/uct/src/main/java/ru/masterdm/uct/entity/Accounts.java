package ru.masterdm.uct.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Accounts for marshalling.
 */
@XmlRootElement(name = "Accounts")
public class Accounts {
    private List<Account> accounts = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Accounts() { }

    /**
     * Constructor with accounts.
     * @param accounts accounts
     */
    public Accounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * accounts field getter.
     * @return accounts
     */
    @XmlElement(name = "Account")
    public List<Account> getAccounts() {
        return accounts;
    }
}
