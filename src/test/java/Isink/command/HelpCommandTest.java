package Isink.command;

import static Isink.command.CommandName.HELP;
import static Isink.command.HelpCommand.HELP_MESSAGE;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
