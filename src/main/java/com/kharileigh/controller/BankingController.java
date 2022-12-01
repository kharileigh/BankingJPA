/**
 *
 * @author kharileigh
 */

package com.kharileigh.controller;

import com.kharileigh.entity.Customer;
import com.kharileigh.model.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BankingController {
    
    
    @Autowired
    private BankingService service;
    
    
    //==================================================
    @RequestMapping("/menu")
    public ModelAndView menuPageController() {
    
        return new ModelAndView("index");
    }
    
    //====================== SEARCH ACCOUNT BY ID ============================
    @RequestMapping("/searchByAccountIdPage")
    public ModelAndView searchByAccountIdController() {
    
        return new ModelAndView("SearchAccountById");
    }
    
    @RequestMapping("/searchByAccountId")
    public ModelAndView searchByAccountId(@RequestParam("customerId") int id) {
        
        ModelAndView modelAndView = new ModelAndView();
        
        Customer customer = service.searchCustomerById(id);
        if(customer != null) {
        
            modelAndView.addObject("customer", customer);
            modelAndView.setViewName("ShowAccount");
        
        } else {
        
            modelAndView.addObject("message", "Account ID : " + id + "does not exist in our system.");
            modelAndView.setViewName("Output");
        }
        
        return modelAndView;
    }
}
