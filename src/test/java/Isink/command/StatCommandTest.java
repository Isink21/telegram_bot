package Isink.command;

import static Isink.command.CommandName.STAT;
import static Isink.command.StatCommand.STAT_MESSAGE;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for StatCommand")
public class StatCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}
