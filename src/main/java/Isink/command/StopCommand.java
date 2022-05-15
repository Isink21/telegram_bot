package Isink.command;

import Isink.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    public static final String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";

    private final SendBotMessageService sendBotMessageService;

    public StopCommand (SendBotMessageService sendBotMessageService){
        this.sendBotMessageService=sendBotMessageService;
    }

    @Override
    public void execute(Update update){
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }

}
