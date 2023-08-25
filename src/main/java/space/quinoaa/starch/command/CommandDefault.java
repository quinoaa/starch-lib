package space.quinoaa.starch.command;

import static org.bukkit.ChatColor.*;

public class CommandDefault {

    public static final CommandNode.Fallback INVALID_SUBCOMMAND = (alias, context) -> {
        context.getSender().sendMessage(RED + "Invalid subcommand: " + alias);
        return true;
    };

    public static final CommandNode.Default NODE_DEFAULT = ctx->{
        ctx.getSender().sendMessage(RED + "Please specify a subcommand");
        return true;
    };
}
