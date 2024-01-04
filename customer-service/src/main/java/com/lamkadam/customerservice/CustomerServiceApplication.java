package com.lamkadam.customerservice;

import com.lamkadam.customerservice.Repository.CustomerRepository;
import com.lamkadam.customerservice.config.GlobalConfig;
import com.lamkadam.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
           List<Customer> Listcustomer = List.of(Customer.builder()
                            .firstName("Hamza")
                            .lastName("lamkadam")
                            .email("hamza.lamkadam@gmail.com")
                             .build(),
            Customer.builder()
                    .firstName("samira")
                    .lastName("salhi")
                    .email("samira.salhi@gmail.com").build());




            customerRepository.saveAll(Listcustomer);


        };


    }
}
