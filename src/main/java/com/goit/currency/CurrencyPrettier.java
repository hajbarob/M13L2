package com.goit.currency;

public interface CurrencyPrettier {

    String prettify(Currency from, Currency to, double rate);
}
