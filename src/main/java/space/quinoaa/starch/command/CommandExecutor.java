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
import space.quinoaa.starch.command.argument.Argument;
import space.quinoaa.starch.command.argument.ArgumentList;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class CommandExecutor implements CommandHandler {
    private final Predicate<Context> permission;
    private final Handler handler;


    public CommandExecutor(Predicate<Context> permission, Handler handler) {
        this.permission = permission;
        this.handler = handler;
    }


    @Override
    public boolean execute(Context context) {
        ArgumentList arguments = new ArgumentList(context);
        Runnable exec = handler.prepare(context, arguments);
        exec.run();
        return true;
    }

    @Override
    public List<String> complete(Context context) {
        ArgumentList arguments = new ArgumentList(context);
        handler.prepare(context, arguments);

        Argument arg = arguments.getFirstEmpty();
        return arg != null ? arg.getCompletion() : Collections.emptyList();
    }

    @Override
    public boolean hasPermission(Context context) {
        return permission.test(context);
    }


    public interface Handler{

        Runnable prepare(Context ctx, ArgumentList args);

    }

    public static CommandExecutor create(Handler handler){
        return new CommandExecutor(ctx->true, handler);
    }

    public static CommandExecutor create(Permission permission, Handler handler){
        return new CommandExecutor(ctx->ctx.getSender().hasPermission(permission), handler);
    }

    public static CommandExecutor create(String permission, Handler handler){
        return new CommandExecutor(ctx->ctx.getSender().hasPermission(permission), handler);
    }

    public static CommandExecutor create(Predicate<Context> permission, Handler handler){
        return new CommandExecutor(permission, handler);
    }

}
