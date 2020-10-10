package com.joannagajzler;

public class Position {
    private String currencyName;
    private Integer converter;
    private String currencyCode;
    private String averageExchangeRate;

    public Position(String currencyName, Integer converter, String currencyCode, String averageExchangeRate) {
        this.currencyName = currencyName;
        this.converter = converter;
        this.currencyCode = currencyCode;
        this.averageExchangeRate = averageExchangeRate;
    }

    @Override
    public String toString() {
        return "Currency Name: '" + currencyName + '\'' +
                ", Currency Code: '" + currencyCode + '\'';

    }

    public String getCurrencyName() {
        return currencyName;
    }

    public Integer getConverter() {
        return converter;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getAverageExchangeRate() {
        return averageExchangeRate;
    }
}
