package ru.masterdm.uct.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import ru.masterdm.uct.entity.Branch;
import ru.masterdm.uct.entity.Certificate;
import ru.masterdm.uct.entity.Customer;

/**
 * Mapper for customers.
 */
@MapperScan
public interface CustomerDao {

    /**
     * Returns all available customers.
     * @param certificate certificate info
     * @return list of customers
     */
    List<Customer> selectCustomers(Certificate certificate);

    /**
     * Returns customer by id.
     * @param custId customer id
     * @return Customer
     */
    Customer selectCustomer(@Param("custId") Long custId);

    /**
     * Returns first branch.
     * @return Branch
     */
    Branch selectBranch();
}
