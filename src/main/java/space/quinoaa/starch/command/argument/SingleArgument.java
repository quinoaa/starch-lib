package space.quinoaa.starch.command.argument;

import org.jetbrains.annotations.Nullable;
import space.quinoaa.starch.command.Context;

public abstract class SingleArgument implements Argument {
    private String argument;

    @Override
    public void parse(Context context) {
        argument = context.getNextArgument();
        parse(context, argument);
    }

    public boolean hasInput(){
        return argument != null;
    }

    public String getRawInput(){
        return argument;
    }

    protected abstract void parse(Context context, @Nullable String argument);
}
