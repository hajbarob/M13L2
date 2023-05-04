package com.goit.currency.impl;

import com.goit.currency.Currency;

public class SimpleCurrencyPrettierTest {

    public static void main(String[] args) {
        SimpleCurrencyPrettier simpleCurrencyPrettier = new SimpleCurrencyPrettier();
        String rate = simpleCurrencyPrettier.prettify(Currency.EUR, Currency.UAH, 40.599998474121094d);

        System.out.println(rate);
    }
}
