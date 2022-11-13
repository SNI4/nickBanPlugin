package me.sn1ch.cmds;

import me.sn1ch.logic.listAddArg;
import me.sn1ch.logic.listRemArg;
import me.sn1ch.nickban;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class nbCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        switch (args[0]) {

            case "add":

                try {
                    sender.sendMessage(listAddArg.addList("banned_names", args[1], "Ник "));
                    return true;

                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Возникла ошибка!: " + e);
                }

                break;

            case "addsw":

                try {
                    sender.sendMessage(listAddArg.addList("banned_names_startswith", args[1], "Префикс ника "));
                    return true;

                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Возникла ошибка!: " + e);
                }

                break;

            case "addew":

                try {
                    sender.sendMessage(listAddArg.addList("banned_names_endswith", args[1], "Конец ника "));
                    return true;

                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Возникла ошибка!: " + e);
                }

                break;

            case "rem":

                try{
                    sender.sendMessage(listRemArg.remList("banned_names", args[1], "Ник ", "full"));
                    return true;

                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Возникла ошибка!: " + e);
                }

                break;

            case "remsw":

                try{
                    sender.sendMessage(listRemArg.remList("banned_names_startswith", args[1], "Префикс ника ", "startswith"));
                    return true;

                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Возникла ошибка!: " + e);
                }

                break;

            case "remew":

                try{
                    sender.sendMessage(listRemArg.remList("banned_names_endswith", args[1], "Конец ника ", "endswith"));
                    return true;

                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Возникла ошибка!: " + e);
                }

                break;

            case "check":

                String kMessage = nickban.getInstance().getConfig().getString("kick_message");

                ArrayList<String> bnameslist = (ArrayList<String>) nickban.getInstance().getConfig().getStringList("banned_names");
                ArrayList<String> bswlist = (ArrayList<String>) nickban.getInstance().getConfig().getStringList("banned_names_startswith");
                ArrayList<String> bewlist = (ArrayList<String>) nickban.getInstance().getConfig().getStringList("bannes_names_endswith");

                int i = 0;

                for (Player p: Bukkit.getServer().getOnlinePlayers()) {

                    String onlinePName = p.getDisplayName();

                    for (String bname: bnameslist) {
                        if (onlinePName.equals(bname)) {
                            p.kickPlayer(ChatColor.RED + kMessage);
                            i++;
                        }
                    }

                    for (String bsw: bswlist) {
                        if (onlinePName.startsWith(bsw)) {
                            p.kickPlayer(ChatColor.RED + kMessage);
                            i++;
                        }
                    }

                    for (String bew: bewlist) {
                        if (onlinePName.endsWith(bew)) {
                            p.kickPlayer(ChatColor.RED + kMessage);
                            i++;
                        }
                    }
                }

                if (i>0){ sender.sendMessage(ChatColor.GREEN + "Игроки с забаненными никами были успеешно очищены!"); }
                else { sender.sendMessage(ChatColor.RED + "Игроки с забаненными никами не найдены."); }

                break;

            default:

                return false;
        }

        return true;
    }
}
