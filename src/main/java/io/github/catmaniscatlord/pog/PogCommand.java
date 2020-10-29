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
        String target;
        String[] message;

        switch (args.length) {
            case 0:
                target = null;
                message = null;
                break;
            case 1:
                target = args[0];
                message = null;
                break;
            default:
                target = args[0];
                message = Arrays.copyOfRange(args, 1 ,args.length);
        }

        PogMessage pog = new PogMessage(sender , target, message, true, true);   
        pog.loop();
        return true;
    }
}
