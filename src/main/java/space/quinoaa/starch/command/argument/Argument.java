package space.quinoaa.starch.command.argument;

import space.quinoaa.starch.command.Context;

import java.util.List;

public interface Argument {

    void parse(Context context);

    List<String> getCompletion();

}
