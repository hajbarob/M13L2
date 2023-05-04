package com.goit.currency.impl;

import com.goit.currency.Currency;
import com.goit.currency.CurrencyService;
import com.goit.currency.dto.CurrencyItemDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PrivatCurrencyServiceImpl implements CurrencyService {
    @Override
    public double getCurrencyRate(Currency currency) {
        String url = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

        String json = "";
        try {
            json = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
        } catch (IOException e) {
            System.out.println("can`t get currency rate");
        }

        Type type = TypeToken.getParameterized(List.class, CurrencyItemDto.class)
                .getType();

        List<CurrencyItemDto> items = new Gson().fromJson(json, type);

        return items.stream()
                .filter(it -> it.getCcy() == currency)
                .filter(it -> it.getBase_ccy() == Currency.UAH)
                .map(it -> it.getBuy())
                .findFirst()
                .orElseThrow();
    }
}
