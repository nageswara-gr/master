package com.nagesh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Account")
public class AccountInfo {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    //@GenericGenerator(name = "native", strategy = "native")
    //@Column(name = "ID")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="AccNbr")
    private long accNr;
    @NonNull
    @Column(name="AccName")
    private String accName;
    @NonNull
    @Column(name="AccType")
    private String accType;
    @Column(name="BalanceDate")
    private Date balanceDate;
    @NonNull
    @Column(name="CurrencyCode")
    private Currency currencyCode;
    @Column(name="Balance")
    private double totalAmount;

}
