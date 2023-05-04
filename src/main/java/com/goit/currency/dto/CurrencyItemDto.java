package com.goit.currency.dto;

import com.goit.currency.Currency;
import lombok.Data;

@Data
public class CurrencyItemDto {

    private Currency ccy;
    private Currency base_ccy;
    private float buy;
    private float sale;

    @Override
    public String toString() {
        return "CurrencyItem{" +
                "ccy=" + ccy +
                ", base_ccy=" + base_ccy +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }
}
