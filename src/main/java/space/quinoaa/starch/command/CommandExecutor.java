package space.quinoaa.starch.command;

import java.util.List;
import java.util.function.Predicate;

public class CommandExecutor implements CommandHandler {
    private final Predicate<Context> permission;


    public CommandExecutor() {
        permission = ctx->true;
    }

    public CommandExecutor(Predicate<Context> permission) {
        this.permission = permission;
    }


    @Override
    public boolean execute(Context context) {
        return false;
    }

    @Override
    public List<String> complete(Context context) {
        return null;
    }

    @Override
    public boolean hasPermission(Context context) {
        return permission.test(context);
    }


    public interface Handler{

    }

}
