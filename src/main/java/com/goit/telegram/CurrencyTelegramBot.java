package com.goit.telegram;

import com.goit.currency.Currency;
import com.goit.currency.CurrencyPrettier;
import com.goit.currency.CurrencyService;
import com.goit.currency.impl.PrivatCurrencyServiceImpl;
import com.goit.currency.impl.SimpleCurrencyPrettier;
import com.goit.telegram.command.StartCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.goit.telegram.utils.CurrencyButtonCreation.addButtonsToMessage;

public class CurrencyTelegramBot extends TelegramLongPollingCommandBot {

    private CurrencyService currencyService;
    private CurrencyPrettier currencyPrettier;

    public CurrencyTelegramBot() {
        register(new StartCommand());
        currencyPrettier = new SimpleCurrencyPrettier();
        currencyService = new PrivatCurrencyServiceImpl();
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        String currencyType = update.getCallbackQuery().getData();
        if (update.hasCallbackQuery()) {
            Currency currency = Currency.valueOf(currencyType);

            String prettiedRate  = currencyPrettier.prettify(currency,
                    Currency.UAH,
                    currencyService.getCurrencyRate(currency));

            SendMessage message = new SendMessage();
            message.setChatId(update.getCallbackQuery().getMessage().getChatId());
            message.setText(prettiedRate + "\n" + "Please select another currency to get rate");
            addButtonsToMessage(message);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                System.out.println("can't process currency button press");
            }
        }

        System.out.println(currencyType);
    }

    @Override
    public String getBotUsername() {
        return Constants.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return Constants.BOT_TOKEN;
    }

}
