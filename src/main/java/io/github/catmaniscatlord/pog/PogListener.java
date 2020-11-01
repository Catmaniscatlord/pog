package io.github.catmaniscatlord.pog;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.entity.Player;
import org.bukkit.Material; 
import org.bukkit.ChatColor;
import java.util.Map;
import java.util.HashMap;

public class PogListener implements Listener
{
    private HashMap<Player,Long> playerTimer = new HashMap<Player,Long>();
    
    @EventHandler
    public void blockBreakEvent(BlockBreakEvent event)
    {
        String message;
        if(event.getBlock().getType().equals(Material.DIAMOND_ORE)) 
        {
            if(playerTimer.containsKey(event.getPlayer()))
            {
                if(System.currentTimeMillis() - playerTimer.get(event.getPlayer()) > 60*1000)
                {
                    message =  "§b§lDiamonds!!!";
                    PogMessage pog = new PogMessage(null, event.getPlayer().getName(), message, false, false);
                    pog.loop();
                    playerTimer.put(event.getPlayer(),  System.currentTimeMillis());
                } 
            }
            else
            {
                message =  "§b§lDiamonds!!!";
                PogMessage pog = new PogMessage(null, event.getPlayer().getName(), message, false, false);
                pog.loop();
                playerTimer.put(event.getPlayer(), System.currentTimeMillis());
            }
        }
    }
}
