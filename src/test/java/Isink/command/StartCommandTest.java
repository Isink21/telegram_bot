package Isink.command;

import static Isink.command.CommandName.START;
import static Isink.command.StartCommand.START_MESSAGE;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for StartCommand")
public class StartCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService, telegramUserService);
    }
}
