package Isink.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    NO("/no"),
    HELP("/help"),
    STAT("/stat");

    private final String commandName;

    CommandName(String commandName){
        this.commandName=commandName;
    }

    public String getCommandName(){
        return commandName;
    }
}
