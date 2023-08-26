/*
 * MIT License
 *
 * Copyright (c) 2023 quinoaa
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package space.quinoaa.starch.command;

import org.bukkit.permissions.Permission;

import java.util.*;
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

        if(context.hasNextArgument()){
            CommandHandler handler = handlers.get(arg);
            if(handler == null) return Collections.emptyList();
            else return handler.complete(context);
        }else{
            List<String> completion = new ArrayList<>();

            handlers.forEach((key, handler)->{
                if(!key.startsWith(arg)) return;
                if(!handler.hasPermission(context)) return;

                completion.add(key);
            });

            return completion;
        }
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
