package Isink.command;

import Isink.SendBotMessageService;
import Isink.user.entity.TelegramUser;
import Isink.user.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    public final static String START_MESSAGE =
        "Привет. Я Javarush Telegram Bot. Я помогу тебе быть в курсе последних " +
            "статей тех авторов, котрые тебе интересны. Я еще маленький и только учусь.";

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        telegramUserService.findByChatId(chatId).ifPresentOrElse(user -> {
                user.setActive(true);
                telegramUserService.save(user);
            },
            () -> {
                TelegramUser telegramUser = new TelegramUser();
                telegramUser.setChatId(chatId);
                telegramUser.setActive(true);
                telegramUserService.save(telegramUser);
            }
        );
        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
