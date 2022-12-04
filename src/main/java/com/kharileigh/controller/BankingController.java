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
    
    
    // ModelAttribute - used when taking the full object / record from database
    // RequestParam - used when taking partial data from object / record from database
    @RequestMapping("/login")
    public ModelAndView loginController(@RequestParam("customerId") int id, @RequestParam("pwd") String password, HttpSession session) {
    
        ModelAndView modelAndView = new ModelAndView();
        Customer sender = service.login(id, password);
        
        if(sender != null) {
        
            // setting logged in customer object to the session
            session.setAttribute("sender", sender);
            modelAndView.setViewName("TransactionPage");
            
        } else {
        
            // if unsuccessful login, prompt user to try again
            modelAndView.addObject("message", "Login failed, Please try again");
            modelAndView.setViewName("index");
        }
        
        return modelAndView;
    }
    
    
    
    //====================== TRANSFER FUNDS FROM ONE ACCOUNT TO ANOTHER ============================
  
}
