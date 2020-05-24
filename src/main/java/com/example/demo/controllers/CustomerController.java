package com.example.demo.controllers;

import com.example.demo.models.CustomerDTO;
import com.example.demo.repositories.CustomerRepositoryImpl;
import com.example.demo.repositories.ICustomerRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CustomerController {

    private ICustomerRepository customerRepository;

    @Autowired
    public CustomerController(){
        customerRepository = new CustomerRepositoryImpl();
    }

    /*
    +----------------------------------+
    |          Administration          |
    +----------------------------------+
    */

    // ---------- DO NOT TOUCH!! ----------

    @GetMapping("/customerAdministration")
    public String administrateCustomer(Model model){
        return "customer/customerAdministration";
    }

    /*
    +----------------------------------+
    |         Create customer          |
    +----------------------------------+
    */

    // ---------- DO NOT TOUCH!! ----------

    @GetMapping("/createCustomer")
    public String createCustomer(Model model){
        model.addAttribute("customer", new CustomerDTO());
        return "customer/createCustomer";
    }

    @PostMapping("/createCustomer")
    public String saveCustomer(@ModelAttribute CustomerDTO customerDTO){
        customerRepository.create(customerDTO);
        return "redirect:/customerAdministration";
    }

    /*
    +---------------------------------+
    |          Find customer          |
    +---------------------------------+
    */

    // ---------- DO NOT TOUCH!! ----------

    @GetMapping("/findCustomer")
    public String findCustomer(Model model){
        // if(model.getAttribute("customer") == null) {
        model.addAttribute("customer", new CustomerDTO()); // laver et tomt customer object, det der står i form {customer}
        //  }
        return "customer/findCustomer";
    }

    @PostMapping("/getCustomerById")
    public String getCustomerById(@ModelAttribute CustomerDTO customer,Model model) {
        CustomerDTO cus = customerRepository.read(customer.getCusId());
        model.addAttribute("customer", cus);
        return "customer/findCustomer";
    }


    /*
    +----------------------------------+
    |          See all customers       |
    +----------------------------------+
    */

    // ---------- DO NOT TOUCH!! ----------

    @GetMapping("/allCustomers")
    public String allCustomers(Model model){
        model.addAttribute("customers", customerRepository.readAll());
        return "customer/allCustomers";
    }

    /*
    +----------------------------------+
    |          Edit customers          |
    +----------------------------------+
    */

    @GetMapping("/editCustomer")
    public String editCustomer(Model model, @RequestParam int cusId){
        CustomerDTO customer = customerRepository.read(cusId);
        model.addAttribute("customer", customer);
        return "customer/editCustomer";
    }

    @PostMapping("/editCustomer")
     public String updateCustomer(@ModelAttribute CustomerDTO customer){
        customerRepository.edit(customer);
        return "redirect:/customerAdministration";
    }

    /*
    +----------------------------------+
    |         Delete customer          |
    +----------------------------------+
    */

    // ---------- DO NOT TOUCH!! ----------

    @GetMapping("/deleteCustomer")
    public String details(Model model, @RequestParam int cusId){
        CustomerDTO cus = customerRepository.read(cusId);
        model.addAttribute("customer", cus);
        return "customer/deleteCustomer";
    }

    @PostMapping ("/deleteCustomer")
    public String deleteForGood(@RequestParam int cusId) {
        customerRepository.delete(cusId);
        return "redirect:/customerAdministration";
    }

}
