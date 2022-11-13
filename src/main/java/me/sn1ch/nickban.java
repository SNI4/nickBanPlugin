package me.sn1ch;

import me.sn1ch.cmds.nbCMD;
import me.sn1ch.cmds.nbCompleter;
import me.sn1ch.logic.Handler;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class nickban extends JavaPlugin {

    private static nickban instance;

    public static nickban getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {


        saveDefaultConfig();
        instance = this;

        Bukkit.getPluginManager().registerEvents(new Handler(), (Plugin)this);
        Objects.requireNonNull(getCommand("nb")).setExecutor(new nbCMD());
        Objects.requireNonNull(getCommand("nb")).setTabCompleter(new nbCompleter());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



}
