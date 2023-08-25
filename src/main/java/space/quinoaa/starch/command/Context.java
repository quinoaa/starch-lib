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
