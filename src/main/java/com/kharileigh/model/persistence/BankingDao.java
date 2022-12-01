/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.persistence;

import com.kharileigh.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("dao")
public interface BankingDao extends JpaRepository<Customer, Integer> {
    
    @Query("FROM Customer WHERE ACCOUNT_ID = :id")
    List<Customer> searchByAccountId(@Param("id") int id);
    
    @Query("UPDATE Customer SET BALANCE = BALANCE + :update WHERE ACCOUNT_ID = :id")
    int updateBalance(@Param("id") int id, @Param("update") double deposit);
}
