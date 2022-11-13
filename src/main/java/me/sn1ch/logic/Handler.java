package me.sn1ch.logic;

import me.sn1ch.nickban;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class Handler implements Listener {


    @EventHandler
    public void join(PlayerJoinEvent e){

        Player p = e.getPlayer();
        String pname = p.getDisplayName();

        String kMessage = nickban.getInstance().getConfig().getString("kick_message");

        List<String> bnames = nickban.getInstance().getConfig().getStringList("banned_names");
        List<String> bnamesSw = nickban.getInstance().getConfig().getStringList("banned_names_startswith");
        List<String> bnamesEw = nickban.getInstance().getConfig().getStringList("banned_names_endswith");



        for (String bname: bnames) {

            if ((pname.equals(bname))) {

                p.kickPlayer(ChatColor.RED + kMessage);
            }
        }

        for (String bsw: bnamesSw) {

            if ((pname.startsWith(bsw))) {

                p.kickPlayer(ChatColor.RED + kMessage);
            }
        }

        for (String bew: bnamesEw){

            if ((pname.endsWith(bew))) {

               p.kickPlayer(ChatColor.RED + kMessage);

            }
        }
    }

}
