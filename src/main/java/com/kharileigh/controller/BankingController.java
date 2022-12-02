/**
 *
 * @author kharileigh
 */

package com.kharileigh.controller;

import com.kharileigh.entity.Customer;
import com.kharileigh.model.service.BankingService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BankingController {
    
    
    @Autowired
    private BankingService service;
    
    
    @RequestMapping("/")
    public ModelAndView loginPageController() {
    
        return new ModelAndView("index");
    }
    
    @RequestMapping("/login")
    public ModelAndView loginController(@ModelAttribute("customer") Customer customer, HttpSession session) {
    
        ModelAndView modelAndView = new ModelAndView();
        
        if(service.login(customer.getCustomerId(), customer.getPassword())) {
        
            modelAndView.addObject("customer", customer);
            session.setAttribute("customer", customer);
            modelAndView.setViewName("index");
            
        } else {
        
            modelAndView.addObject("message", "Incorrect Account Details, please try again");
            modelAndView.addObject("customer", new Customer());
            modelAndView.setViewName("Login");
        }
        
        return modelAndView;
    }
    
    
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
