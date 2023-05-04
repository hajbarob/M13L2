package com.goit.currency.impl;

import com.goit.currency.Currency;
import com.goit.currency.CurrencyService;

public class PrivatCurrencyServiceImplTest {

    public static void main(String[] args) {
        CurrencyService currencyService = new PrivatCurrencyServiceImpl();
        double currencyRate = currencyService.getCurrencyRate(Currency.EUR);
        System.out.println(currencyRate);
    }
}
