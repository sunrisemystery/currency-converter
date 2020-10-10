package com.joannagajzler;

public class Conversion {

    //This function converts given amount to wanted currency
    public Double convert(Position input, Position output, Double amount) {

        //changing commas to dots (XML file has commas in double values)
        double inputAverageExchangeRate = Double.parseDouble(input.getAverageExchangeRate().replace(',', '.'));
        double outputAverageExchangeRate = Double.parseDouble(output.getAverageExchangeRate().replace(',', '.'));

        return inputAverageExchangeRate * amount * output.getConverter() / (outputAverageExchangeRate * input.getConverter());
    }
}
