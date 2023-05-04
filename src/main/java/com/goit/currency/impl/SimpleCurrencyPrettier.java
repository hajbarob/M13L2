package com.goit.currency.impl;

import com.goit.currency.Currency;
import com.goit.currency.CurrencyPrettier;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SimpleCurrencyPrettier implements CurrencyPrettier {

    public static final String PATTERN = "Current rate for %s / %s pair = %s";

    @Override
    public String prettify(Currency from, Currency to, double rate) {
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.CEILING);
        String formatedRate = df.format(rate);
        return String.format(PATTERN, from, to, formatedRate);
    }
}
