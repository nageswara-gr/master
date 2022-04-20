package com.nagesh.model;

public enum Currency {
    AUD("AUD"),
    USD("USD"),
    SGD("SGD"),
    UKD("UKD");

    private Currency currencyCode;
    Currency(String aud) {

    }

    public static Currency fromValue(String val){
        return valueOf(val);
    }

    public Currency getCurrencyCode() {
        return currencyCode;
    }
}
