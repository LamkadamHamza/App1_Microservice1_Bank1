package com.lamkadam.customerservice.web;

import com.lamkadam.customerservice.Repository.CustomerRepository;
import com.lamkadam.customerservice.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerRepository customerRepository;


    @GetMapping("/customers")
    public List<Customer> customerList(){
        return  customerRepository.findAll();
    }

    @GetMapping("/customer{id}")
    public  Customer getCustomer(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }

}
