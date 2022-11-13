package me.sn1ch.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class nbCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args.length == 1){
            return List.of(
                    "add",
                    "addsw",
                    "addew",
                    "rem",
                    "remsw",
                    "remew",
                    "check"
            );
        }
        else if (args.length == 2){
            List<String> pNames = new ArrayList<>();
            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);
            for (int i = 0; i < players.length; i++){
                pNames.add(players[i].getName());
            }

            return pNames;
        }

        return null;
    }
}
