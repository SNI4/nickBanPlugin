package me.sn1ch.logic;

import me.sn1ch.nickban;
import org.bukkit.ChatColor;

import java.util.ArrayList;

public class listAddArg {
    public static String addList(String path, String name, String type){

        ArrayList<String> blist = (ArrayList<String>) nickban.getInstance().getConfig().getStringList(path);

        for (String bname: blist){
            if (bname.equals(name)){
                return (ChatColor.RED + type + ChatColor.DARK_PURPLE + name + ChatColor.RED + " уже забанен!");
            }
        }

        blist.add(name);
        nickban.getInstance().getConfig().set(path, blist);
        nickban.getInstance().saveConfig();
        return (ChatColor.GREEN + type + ChatColor.DARK_PURPLE + name + ChatColor.GREEN + " успешно забанен!");
    }
}
