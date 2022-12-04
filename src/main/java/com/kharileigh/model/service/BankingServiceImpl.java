/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.service;

import com.kharileigh.entity.Customer;
import com.kharileigh.model.persistence.BankingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class BankingServiceImpl implements BankingService {

    
    // Automatically configures DAO dependency to be used by Service
    @Autowired
    private BankingDao dao;

    @Override
    public Customer login(int customerId, String password) {
        
        // TRY - to get Customer by fetching their ID & Password
        try {
            
            Customer activeCustomer = dao.findByCustomerIdAndPassword(customerId, password);
            return activeCustomer;
            
        } catch(Exception exception) {
            
            return null;
        }
    }

    
    @Override
    public Customer transferFunds(int senderId, int recipientId, double deposit) {
        
        // GET - get senders ID
        Customer sender = dao.findById(senderId).get();
        
        // check if customer has enough money -> less than deposit amount, return null
        if (sender.getBalance() < deposit) {
            
            return null;
        
        // set senders balance decrementing deposit, set recipient's balance as incrementing deposit
        } else {
        
            Customer recipient = dao.findById(recipientId).orElse(null);
            
            // if recipient exist, update both balances
            if(recipient != null) {
                
                recipient.setBalance(recipient.getBalance() + deposit);
                sender.setBalance(sender.getBalance() - deposit);
                dao.save(recipient);
                dao.save(sender);
                
                // return sender because currently logged in customer using the session
                return sender;
                
            } else {
            
                return null;
            }
        }
        
    }
    
    
    
    
    
}
