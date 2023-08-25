package space.quinoaa.starch.command;

import org.bukkit.permissions.Permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CommandNode implements CommandHandler {
    private final Map<String, CommandHandler> handlers = new HashMap<>();
    private Predicate<Context> permission = s->true;
    private Fallback fallback = CommandDefault.INVALID_SUBCOMMAND;
    private Default defaultHandler = CommandDefault.NODE_DEFAULT;




    @Override
    public boolean execute(Context context) {
        String argument = context.getNextArgument();
        if(argument == null) return defaultHandler.handle(context);

        CommandHandler handler = handlers.get(argument);

        if(handler == null || !handler.hasPermission(context)){
            return fallback.handle(argument, context);
        }

        return handler.execute(context);
    }

    @Override
    public List<String> complete(Context context) {
        String arg = context.getNextArgument();
        if(arg == null) return new ArrayList<>(handlers.keySet());

        List<String> completion = new ArrayList<>();

        handlers.forEach((key, handler)->{
            if(!key.startsWith(arg)) return;
            if(!handler.hasPermission(context)) return;

            completion.add(key);
        });

        return completion;
    }

    @Override
    public boolean hasPermission(Context context) {
        return permission.test(context);
    }



    public void removeSubCommand(String name){
        handlers.remove(name);
    }



    public CommandNode addSubCommand(String name, CommandHandler handler){
        handlers.put(name, handler);
        return this;
    }



    public CommandNode setPermission(Permission permission){
        this.permission = ctx->ctx.getSender().hasPermission(permission);
        return this;
    }

    public CommandNode setPermission(String permission){
        this.permission = ctx->ctx.getSender().hasPermission(permission);
        return this;
    }

    public CommandNode setPermission(Predicate<Context> contextPredicate){
        this.permission = contextPredicate;
        return this;
    }



    public CommandNode setFallback(Fallback fallback){
        this.fallback = fallback;
        return this;
    }

    public CommandNode setFallback(BiConsumer<String, Context> fallback){
        this.fallback = (name, ctx)->{
            fallback.accept(name, ctx);
            return true;
        };
        return this;
    }



    public CommandNode setDefault(Default defaultHandler){
        this.defaultHandler = defaultHandler;
        return this;
    }

    public CommandNode setDefault(Consumer<Context> handler){
        this.defaultHandler = ctx->{
            handler.accept(ctx);
            return true;
        };
        return this;
    }



    public static CommandNode create(){
        return new CommandNode();
    }

    public interface Fallback{
        boolean handle(String alias, Context context);
    }

    public interface Default{
        boolean handle(Context context);
    }
}
