package io.github.catmaniscatlord.pog;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.Material; 
import org.bukkit.ChatColor;

public class PogListener implements Listener
{
    @EventHandler
    public void blockBreakEvent(BlockBreakEvent event)
    {
        String message;
        if(event.getBlock().getType().equals(Material.DIAMOND_ORE)) 
        {
            message =  "§b§lDiamonds!!!";
            PogMessage pog = new PogMessage(null, event.getPlayer().getName(), message, false, false);
            pog.loop();
        }
    }
}
