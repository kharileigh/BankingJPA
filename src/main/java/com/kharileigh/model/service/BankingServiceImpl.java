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

    
    @Autowired
    private BankingDao dao;
    
    @Override
    public Customer searchCustomerById(int id) {
        
        return dao.findById(id).orElse(null);
    }

    @Override
    public boolean updateBalance(int id, double deposit) {
        
        return dao.updateBalance(id, deposit) > 0;
    }
    
    
}
