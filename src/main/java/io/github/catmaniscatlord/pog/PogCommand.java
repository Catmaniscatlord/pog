package io.github.catmaniscatlord.pog;

import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;


public class PogCommand implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        PogMessage pog = new PogMessage(sender , args[0], Arrays.copyOfRange(args, 1 ,args.length), true, true);   
        pog.loop();
        return true;
    }
}
