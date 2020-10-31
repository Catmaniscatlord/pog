package io.github.catmaniscatlord.pog;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Pog extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("pog").setExecutor(new PogCommand());
        getServer().getPluginManager().registerEvents(new PogListener(),this);
    }

    @Override
    public void onDisable() {
    }   
}