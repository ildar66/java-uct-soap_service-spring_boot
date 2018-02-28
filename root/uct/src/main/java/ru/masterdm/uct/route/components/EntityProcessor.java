package ru.masterdm.uct.route.components;

import org.springframework.stereotype.Component;
import ru.masterdm.uct.entity.Account;
import ru.masterdm.uct.entity.Accounts;
import ru.masterdm.uct.entity.Branch;
import ru.masterdm.uct.entity.Customer;
import ru.masterdm.uct.entity.Customers;
import ru.masterdm.uct.entity.ErrorCode;
import ru.masterdm.uct.entity.Event;

import java.util.List;

/**
 * Camel component for uct's entities generation.
 */
@Component("entityProcessor")
public class EntityProcessor {

    /**
     * Creates new event.
     * @param code error code
     * @param error error text
     * @return Event
     */
    public Event createEvent(ErrorCode code, String error) {
        return new Event(code, error);
    }

    /**
     * Creates new Customers.
     * @param customers list of customers
     * @return Customers
     */
    public Customers createCustomers(List<Customer> customers) {
        return new Customers(customers);
    }

    /**
     * Creates new Accounts.
     * @param accounts list of accounts
     * @param branch branch
     * @param customer customer
     * @return Accounts
     */
    public Accounts createAndFillAccounts(List<Account> accounts, Branch branch, Customer customer) {
        for (Account account: accounts) {
            account.setBranch(branch);
            account.setCustomer(customer);
        }
        return new Accounts(accounts);
    }
}
