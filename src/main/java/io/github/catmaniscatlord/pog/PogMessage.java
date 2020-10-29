package io.github.catmaniscatlord.pog;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;

public class PogMessage{
    private CommandSender sender;
    private String target;
    private String message = "";
    private String userMessage = "";
    private boolean broadcast;
    private boolean targetIsPlayer;
    private boolean userRun;

    public PogMessage(CommandSender sender, String target, String[] userMessage, boolean broadcast, boolean userRun) {
        this.sender = sender;
        setTarget(target);
        setUserMessage(userMessage);
        this.broadcast = broadcast;
        this.userRun = userRun; 
    }

    public void loop()
    {
        createMessage();
        if (this.targetIsPlayer) {
            Player target = Bukkit.getPlayer(this.target);
            target.sendMessage(ChatColor.GOLD + "You have been pogged" + ChatColor.RESET);
        }
        if (this.broadcast) {
            Bukkit.broadcastMessage(this.message);
        }
        else {
            if(userRun) {
                this.sender.sendMessage(this.message);
            }
            if (this.targetIsPlayer) {
                Player target = Bukkit.getPlayer(this.target);
                target.sendMessage(this.message);
            }
        }
    }

    private void createMessage() {
        if(userRun) {
            if(!(this.sender instanceof Player)) {
                this.message += ChatColor.AQUA + "The Server " + ChatColor.RESET;
            }
            else {
                this.message += ChatColor.AQUA + this.sender.getName() + " " + ChatColor.RESET;
            }
            this.message += "has pogged "+ ChatColor.AQUA + this.target + ChatColor.RESET;
        }
        else {
            this.message += ChatColor.GOLD + "Pog" + ChatColor.RESET;
        }
        if(!this.userMessage.isBlank()) {
            this.message +=  "\n" + ChatColor.BLUE + this.userMessage + ChatColor.RESET;
        }
    }
    
    /**
     * check if the message has the formatting character then formats the string accordingly 
     * 
     */
    private void colorMessage() {
        if(this.userMessage.contains("&")) {
            this.userMessage = ChatColor.translateAlternateColorCodes('&',this.userMessage+"&r");
        }
    }

    /**
     * checks if the target is a player, if it is then it checks the targetIsPlayer value to true 
     * then it sets the target to the given string
     * @param target the target
     */
    public void setTarget(String target) {
        if(target != null) {
            if(Bukkit.getPlayer(target) != null)
            {
                this.targetIsPlayer = true;
            }
            this.target = target;
        }
        else {
            this.target = "";
        }   
    }

    /**
     * sets the pog message based off of a string 
     *
     * @param message the message
     */
    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
        colorMessage();
    }

    /**
     * sets the pog message based off of a string array
     *
     * @param message the message in a string array
     */
    public void setUserMessage(String[] userMessage) {
        if(userMessage != null) {
            for(String i : userMessage)
            {
                this.userMessage += i + " ";
            }
            this.userMessage.trim();
            colorMessage();
        }
        else {
            this.userMessage = "";
        }
    }

    /**
     * sets wether or not the message is broadcast
     *
     * @param broadcast
     */
    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }
}