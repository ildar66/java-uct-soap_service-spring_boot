package ru.masterdm.uct.repository;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import ru.masterdm.uct.entity.Account;

import java.util.List;

/**
 * Mapper for customers.
 */
@MapperScan
public interface AccountDao {

    /**
     * Returns all accounts for pointed customer.
     * If CustId == null method returns information about all customers.
     * @param custId customer's id
     * @param account account
     * @return list of accounts
     */
    List<Account> selectAccounts(@Param("custId") Long custId, @Param("account") String account);

}
