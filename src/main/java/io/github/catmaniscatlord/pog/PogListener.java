package io.github.catmaniscatlord.pog;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import org.bukkit.Material; 
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Bukkit;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class PogListener implements Listener
{
    private HashMap<String,Long> timerEvents = new HashMap<String, Long>();
    private HashMap<Player,HashMap<String,Long>> playerTimer = new HashMap<Player,HashMap<String,Long>>();

    public PogListener() {
        timerEvents.put("mineDiamonds", (long) 0.0);
        timerEvents.put("dropItem", (long) 0.0);
    }
    
    @EventHandler
    public void blockBreakEvent(BlockBreakEvent event)
    {
        String message;
        if(event.getBlock().getType().equals(Material.DIAMOND_ORE)) 
        {
            if(playerTimer.containsKey(event.getPlayer()))
            {
                if(System.currentTimeMillis() - playerTimer.get(event.getPlayer()).get("mineDiamonds") > 60*1000)
                {
                    message =  "§b§lDiamonds!!!";
                    PogMessage pog = new PogMessage(null, event.getPlayer().getName(), message, false, false);
                    pog.loop();
                    playerTimer.get(event.getPlayer()).put("mineDiamonds",System.currentTimeMillis());
                }
            }
            else
            {
                message =  "§b§lDiamonds!!!";
                PogMessage pog = new PogMessage(null, event.getPlayer().getName(), message, false, false);
                pog.loop();
                playerTimer.put(event.getPlayer(), timerEvents);
            }
        }
    }

    @EventHandler
    public void playerDropItemEvent(PlayerDropItemEvent event)
    {
        if(playerTimer.containsKey(event.getPlayer()))
        {
            if(System.currentTimeMillis() - playerTimer.get(event.getPlayer()).get("dropItem") > 60*1000)
            {
                event.getPlayer().sendMessage("§lYEET");
                playerTimer.get(event.getPlayer()).put("dropItem",System.currentTimeMillis());
            } 
        }
        else
        {
            event.getPlayer().sendMessage("§l YEET");        
            timerEvents.put("dropItem", System.currentTimeMillis());
            playerTimer.put(event.getPlayer(), timerEvents);
        }
    }

    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent event)
    {
        if(event.getItem() != null)
        {
            if(event.getItem().getType().equals(Material.DIAMOND_SHOVEL))
            {
                ArrayList<Player> potentialTargets = new ArrayList<Player>(Bukkit.getOnlinePlayers());
                potentialTargets.remove(event.getPlayer());
                int rand = new Random().nextInt(potentialTargets.size());
                Player theUnluckySole =  potentialTargets.get(rand);
                theUnluckySole.setHealth(0);
            }
        }
    }
}