package Isink.command;

import static Isink.command.CommandName.*;

import Isink.SendBotMessageService;
import Isink.user.service.TelegramUserService;
import com.google.common.collect.ImmutableMap;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {

        commandMap = ImmutableMap.<String, Command>builder()
            .put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService))
            .put(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService))
            .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
            .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
            .put(STAT.getCommandName(), new StatCommand(sendBotMessageService, telegramUserService))
            .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
