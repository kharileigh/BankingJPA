/**
 *
 * @author kharileigh
 */

package com.kharileigh.controller;

import com.kharileigh.model.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    //==================================================
    
}
