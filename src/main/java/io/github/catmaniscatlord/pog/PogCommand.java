package io.github.catmaniscatlord.pog;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;


public class PogCommand implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length < 1){
            sender.sendMessage("pog");
        }
        else{
            if(Bukkit.getPlayer(args[0]) != null){
                Player target = Bukkit.getPlayer(args[0]);
                String message = sender.getName() + " has Pogged you!";
                if(args.length > 1)
                {
                    message += "\n" + pogMessage(args);
                }
                sender.sendMessage("You have pogged " + args[0]);
                target.sendMessage(message);
            }
        }       
        return true;
    }

    private String pogMessage(String[] args){
        String message = "";
    
        for(int i=1; i < args.length;i++)
        {
            message += args[i] + " ";
        }
        
        return  ChatColor.translateAlternateColorCodes('&',message+"&r") + "pog!";
    }
}
