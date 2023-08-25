package space.quinoaa.starch.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Nullable;

public class Context {
    private final CommandSender sender;
    private final Command command;
    private final String alias;
    private final String[] arguments;
    private int argumentIndex = 0;

    public Context(CommandSender sender, Command command, String alias, String[] arguments) {
        this.sender = sender;
        this.command = command;
        this.alias = alias;
        this.arguments = arguments;
    }



    public @Nullable String getNextArgument(){
        if(hasNextArgument()) return null;
        String argument = arguments[argumentIndex];
        argumentIndex++;

        return argument;
    }

    public boolean hasNextArgument(){
        return argumentIndex < arguments.length;
    }



    public CommandSender getSender() {
        return sender;
    }

    public Command getCommand() {
        return command;
    }

    public String getAlias() {
        return alias;
    }

    public String[] getRawArguments() {
        return arguments;
    }


    public int getArgumentIndex() {
        return argumentIndex;
    }

    public void setArgumentIndex(int argumentIndex) {
        this.argumentIndex = argumentIndex;
    }
}
