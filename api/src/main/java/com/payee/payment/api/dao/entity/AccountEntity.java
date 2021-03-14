package com.payee.payment.api.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity(name = "accounts")
public class AccountEntity {

    @Id
    private String iban;

    private String status;

    private BigDecimal balance;

    @Column(name = "account_management_system")
    private String accountManagementSystem;

}
