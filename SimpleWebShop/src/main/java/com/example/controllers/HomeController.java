package com.example.module.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.module.webshop.entity.Customer;
import com.example.module.webshop.services.CustomerService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class HomeController {

    private CustomerService customerService;

    @Autowired
    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("Home")
    public String openHome(Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("Current User") != null){
            return "redirect:Product";
        }

        model.addAttribute("message", "Deze homepage tekst");
        model.addAttribute("customer", new Customer("", ""));
        return "customerLogin";
    }



    @GetMapping("AddAccount")
    public String signIn(Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("Current User") != null){
            return "redirect:Home";
        }

       model.addAttribute("customer", new Customer("", ""));
        return "addCustomer";
    }

    @PostMapping("AddAccount")
    public String AddAccount(Model model, @ModelAttribute("customer") Customer customer) {

        if (customer.getUsername() == null) {
            return "redirect:AddAccount";
        } else {
            customerService.saveCustomer(customer);
            return "redirect:Home";

        }
    }
    @PostMapping("Login")
    public String login(Model model, @ModelAttribute("customer") Customer customer, HttpSession httpSession) {

        Customer foundCustomer = customerService.checkIfCustomerExists(customer);
        if (foundCustomer == null) {
            return "redirect:Home";
        } else {
            httpSession.setAttribute("Current User", customer.getUsername());
            return "redirect:Product";

        }
    }

    @GetMapping("Product")
    public String homePage (Model model){

model.addAttribute("category", "Voorbeeld_Cat");
        model.addAttribute("productsList", new ArrayList<>());
        return "products";
    }

    @GetMapping("/logout")
    public String logout (HttpSession httpSession){

        httpSession.setAttribute("Current User", null);
        return "redirect:Home";
    }
}

