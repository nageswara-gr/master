package com.nagesh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Locale;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="TransNbr")
    private long trnsNr;
    @Column(name="AccNbr")
    private long accNr;
    @Column(name="AccName")
    private String accName;
    @Column(name="TodayDate")
    private Date valueDate;
    @Column(name="CurrencyCode")
    private Currency currencyCode;
    @Column(name="CreditAmount")
    private Double crdAmount;
    @Column(name="DebitAmount")
    private Double dbtAmount;
    @Column(name="Mode")
    private TransactionType modeOfTransaction;
    @Column(name="TransactionDetail")
    private String remarks;

}
