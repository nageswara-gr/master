package com.nagesh.model;

public enum TransactionType {
    CREDIT("CREDIT"),
    DEBIT("DEBIT");

    private TransactionType mode;
    TransactionType(String mode) {

    }
    public TransactionType getMode() {
        return mode;
    }
}


