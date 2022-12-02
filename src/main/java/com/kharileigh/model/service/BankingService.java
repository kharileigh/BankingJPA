/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.service;

import com.kharileigh.entity.Customer;


public interface BankingService {
    
    // CUSTOMER OBJECT - to get validate login credentials & update full record when data is manipulated
    Customer login(int customerId, String password);
    
    Customer transferFunds(int senderId, int recipientId, double deposit);
    
}
