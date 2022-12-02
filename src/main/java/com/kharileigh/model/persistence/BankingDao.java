/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.persistence;

import com.kharileigh.entity.Customer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// GET DATA FROM DATABASE
@Repository("dao")
public interface BankingDao extends JpaRepository<Customer, Integer> {
    
    // Gets FULL Object / Record from Database, Use PARTIAL DATA ELSWHERE 
    // JPQL Method - use properties with function
    public Customer findByCustomerIdAndPassword(int id, String password);
   
}
