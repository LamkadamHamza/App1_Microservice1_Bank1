package com.lamkadam.accountservice.entities;

import com.lamkadam.accountservice.enums.AccountType;
import com.lamkadam.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Entity
@ToString
@Getter @Setter  @AllArgsConstructor @NoArgsConstructor
@Builder
public class BankAccount {

    @Id
    private String accountId;
    private double balance ;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING )
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
