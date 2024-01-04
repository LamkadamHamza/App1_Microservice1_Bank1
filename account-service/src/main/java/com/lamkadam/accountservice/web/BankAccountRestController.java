package com.lamkadam.accountservice.web;

import com.lamkadam.accountservice.Repository.BankAccountRepository;
import com.lamkadam.accountservice.clients.CustomerRestClient;
import com.lamkadam.accountservice.entities.BankAccount;
import com.lamkadam.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BankAccountRestController {


    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public BankAccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")

    public List<BankAccount> accountList ()
    {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        bankAccounts.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return  bankAccounts;
    }


    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById (@PathVariable String id){


      BankAccount bankAccount=  bankAccountRepository.findById(id).get();
      Customer customer= customerRestClient.findCustomerById(bankAccount.getCustomerId());
      bankAccount.setCustomer(customer);
      return  bankAccount;
    }
}
