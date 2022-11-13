package me.sn1ch.logic;

import me.sn1ch.nickban;
import org.bukkit.ChatColor;

import java.util.ArrayList;

public class listRemArg {
    public static String remList(String path, String name, String disp, String type){

        ArrayList<String> blist = (ArrayList<String>) nickban.getInstance().getConfig().getStringList(path);

        switch (type){

            case "full":

                for (String bname: blist){

                    if (bname.equals(name)){

                        blist.remove(name);
                        nickban.getInstance().getConfig().set(path, blist);
                        nickban.getInstance().saveConfig();

                        return (ChatColor.GREEN + disp + ChatColor.DARK_PURPLE + name + ChatColor.GREEN + " успешно удален!");
                    }
                }
                break;

            case "startswith":

                for (String bname: blist){

                    if (bname.startsWith(name)){

                        blist.remove(name);
                        nickban.getInstance().getConfig().set(path, blist);
                        nickban.getInstance().saveConfig();

                        return (ChatColor.GREEN + disp + ChatColor.DARK_PURPLE + name + ChatColor.GREEN + " успешно удален!");
                    }
                }
                break;

            case "endswith":

                for (String bname: blist){

                    if (bname.endsWith(name)){

                        blist.remove(name);
                        nickban.getInstance().getConfig().set(path, blist);
                        nickban.getInstance().saveConfig();

                        return (ChatColor.GREEN + disp + ChatColor.DARK_PURPLE + name + ChatColor.GREEN + " успешно разбанен!");
                    }
                }
                break;
        }



        return (ChatColor.RED + disp + ChatColor.DARK_PURPLE + name + ChatColor.RED + " не забанен!");
    }
}
