package space.quinoaa.starch.command.argument;

import space.quinoaa.starch.command.Context;

public class ArgumentList {
    private final Context context;

    public ArgumentList(Context context) {
        this.context = context;
    }

    public <T extends Argument> T add(T argument){
        argument.parse(context);
        return argument;
    }
}
