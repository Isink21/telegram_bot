package Isink.command;

import Isink.SendBotMessageService;
import Isink.user.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    public static final String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public StopCommand (SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService){
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update){
        String chatId = update.getMessage().getChatId().toString();
        sendBotMessageService.sendMessage(chatId, STOP_MESSAGE);
        telegramUserService.findByChatId(chatId).ifPresent(user -> {
            user.setActive(false);
            telegramUserService.save(user);
        });

    }

}
