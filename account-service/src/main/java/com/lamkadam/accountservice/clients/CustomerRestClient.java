package com.lamkadam.accountservice.clients;


import com.lamkadam.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "serviceCustomer", fallbackMethod = "getDefaultCustomers")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    List<Customer> allCustomers();

    default  Customer getDefaultCustomers(Long id , Exception exception){

        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not vailable");
        customer.setLastName("Not vailable");
        customer.setEmail("Not vailable");
        return customer;
    }
}
