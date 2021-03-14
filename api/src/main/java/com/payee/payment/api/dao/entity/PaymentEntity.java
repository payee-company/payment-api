package com.payee.payment.api.dao.entity;

import com.payee.payment.api.Constants;
import com.payee.payment.api.resource.model.Transaction;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity(name = "payments")
public class PaymentEntity {

    @Id
    private String id;

    private String status;

    @Column(name= "debtor_iban")
    private String debtorIban;

    @Column(name= "creditor_iban")
    private String creditorIban;

    private BigDecimal amount;

    @Column(name= "payment_date")
    private LocalDateTime paymentDate;

    public static PaymentEntity from(AccountEntity debtor, AccountEntity creditor, Transaction transaction){
        PaymentEntity entity = new PaymentEntity();
        entity.setId(transaction.getTransactionId());
        entity.setAmount(transaction.getAmount());
        entity.setCreditorIban(creditor.getIban());
        entity.setDebtorIban(debtor.getIban());
        entity.setStatus(Constants.PAYMENT_IN_PROGRESS);
        return entity;
    }

}
