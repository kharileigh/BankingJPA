/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.service;

import com.kharileigh.entity.Customer;


public interface BankingService {
    
    Customer searchCustomerById(int id);
    
    boolean login(String name, String password);
    
    boolean updateBalance(int id, double deposit);
    
}
