package com.goit.telegram.command;


import com.goit.currency.Currency;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.Collections;

import static com.goit.telegram.utils.CurrencyButtonCreation.addButtonsToMessage;

public class StartCommand extends BotCommand {
    public StartCommand() {
        super("start", "start command description");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        SendMessage message = new SendMessage();
        message.setText("Please select currency to get rate");
        message.setChatId(chat.getId());

        addButtonsToMessage(message);

        System.out.println("start command execution ");

        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("can't send message to user");
        }
        System.out.println("start command executed ");
    }
}
