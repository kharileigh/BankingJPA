/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.persistence;

import com.kharileigh.entity.Customer;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("dao")
public interface BankingDao extends JpaRepository<Customer, Integer> {
    
   
    public Customer findByAccountNameAndPassword(String name, String password);
    
    @Modifying
    @Transactional
    @Query("UPDATE Customer SET BALANCE = BALANCE + :update WHERE ACCOUNT_ID = :id")
    int updateBalance(@Param("id") int id, @Param("update") double deposit);
}
