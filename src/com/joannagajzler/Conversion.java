package com.joannagajzler;

public class Conversion {

    public Double convert(Position a, Position b, Double value) {

        double aAverageExchangeRate = Double.parseDouble(a.getAverageExchangeRate().replace(',', '.'));
        double bAverageExchangeRate = Double.parseDouble(b.getAverageExchangeRate().replace(',', '.'));

        return aAverageExchangeRate * value * b.getConverter() / (bAverageExchangeRate * a.getConverter());


    }
}
