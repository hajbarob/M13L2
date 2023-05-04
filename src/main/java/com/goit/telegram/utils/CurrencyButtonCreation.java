package com.goit.telegram.utils;

import com.goit.currency.Currency;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyButtonCreation {
    public static void addButtonsToMessage(SendMessage message) {

        List<InlineKeyboardButton> buttons = Arrays.stream(Currency.values())
                .filter(currency -> currency != Currency.UAH)
                .map(currency -> InlineKeyboardButton
                        .builder()
                        .text(currency.name())
                        .callbackData(currency.name())
                        .build())
                .collect(Collectors.toList());

        InlineKeyboardMarkup ikm = InlineKeyboardMarkup
                .builder()
                .keyboard(Collections.singleton(
                        buttons
                )).build();

        message.setReplyMarkup(ikm);
    }
}
