package space.quinoaa.starch.command.argument;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import space.quinoaa.starch.command.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PlayerArgument extends SingleArgument {
    private final Supplier<? extends Collection<? extends Player>> playerSupplier;
    private final Function<String, Player> playerGetter;
    private final Predicate<Player> playerPredicate;
    private Player player = null;

    public PlayerArgument(Supplier<? extends Collection<? extends Player>> playerSupplier,
                          Function<String, Player> playerGetter, Predicate<Player> playerPredicate) {
        this.playerSupplier = playerSupplier;
        this.playerGetter = playerGetter;
        this.playerPredicate = playerPredicate;
    }

    @Override
    protected void parse(Context context, @Nullable String argument) {
        player = null;

        if(argument != null){
            Player player = playerGetter.apply(argument);
            if(!playerPredicate.test(player)) return;

            this.player = player;
        }
    }

    @Override
    public List<String> getCompletion() {
        List<String> complete = new ArrayList<>();

        String arg = getRawInput();
        for (Player plr : playerSupplier.get()) {
            if(arg != null && !plr.getName().startsWith(arg)) continue;
            if(!playerPredicate.test(plr)) continue;

            complete.add(plr.getName());
        }

        return complete;
    }



    public boolean hasFoundPlayer(){
        return player != null;
    }

    public Player getPlayer(){
        return player;
    }




    public static PlayerArgument any(){
        return new PlayerArgument(
                Bukkit::getOnlinePlayers,
                Bukkit::getPlayerExact,
                plr->true
        );
    }

    public static PlayerArgument ofSet(Set<Player> players){
        return new PlayerArgument(
                ()->players,
                name->players.stream().filter(plr->plr.getName().equals(name)).findAny().orElse(null),
                plr->true
        );
    }

    public static PlayerArgument filter(Predicate<Player> predicate){
        return new PlayerArgument(
                Bukkit::getOnlinePlayers,
                Bukkit::getPlayerExact,
                predicate
        );
    }

    public static PlayerArgument filteredSet(Set<Player> players, Predicate<Player> predicate){
        return new PlayerArgument(
                ()->players,
                name->players.stream().filter(plr->plr.getName().equals(name)).findAny().orElse(null),
                predicate
        );
    }
}
