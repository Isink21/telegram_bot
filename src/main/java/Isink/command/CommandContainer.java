package Isink.command;

import static Isink.command.CommandName.HELP;
import static Isink.command.CommandName.NO;
import static Isink.command.CommandName.START;
import static Isink.command.CommandName.STOP;

import Isink.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<String, Command>builder()
            .put(START.getCommandName(), new StartCommand(sendBotMessageService))
            .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
            .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
            .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
            .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
