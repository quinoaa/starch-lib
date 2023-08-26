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

import org.bukkit.command.*;
import org.bukkit.command.CommandExecutor;

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

    default void register(PluginCommand command){
        command.setExecutor(this);
        command.setTabCompleter(this);
    }
}
