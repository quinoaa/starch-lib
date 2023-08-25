package space.quinoaa.starch.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public interface CommandHandler extends CommandExecutor, TabCompleter {
    boolean execute(Context context);
    List<String> complete(Context context);
    boolean hasPermission(Context context);



    @Override
    default boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return execute(new Context(commandSender, command, s, strings));
    }

    @Override
    default List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return complete(new Context(commandSender, command, s, strings));
    }
}
