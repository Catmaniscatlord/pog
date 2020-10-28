package io.github.catmaniscatlord.pog;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Pog extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("pog").setExecutor(new PogCommand());
    }

    @Override
    public void onDisable() {
    }   
}