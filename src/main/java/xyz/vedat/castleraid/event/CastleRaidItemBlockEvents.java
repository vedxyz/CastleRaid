package xyz.vedat.castleraid.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import xyz.vedat.castleraid.CastleRaidMain;
import xyz.vedat.castleraid.CastleRaidPlayer;
import xyz.vedat.castleraid.classes.ClassItemFactory;

public class CastleRaidItemBlockEvents implements Listener {
    
    CastleRaidMain plugin;
    
    public CastleRaidItemBlockEvents(CastleRaidMain plugin) {
        
        this.plugin = plugin;
        
    }
    
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        
        Player player = event.getPlayer();
        CastleRaidPlayer crPlayer = plugin.getCrPlayers().get(player.getUniqueId());
        
        if (crPlayer == null) {
            return;
        }
        
        if (crPlayer.isCarryingBeacon() && event.getTo().getBlock().getLocation().equals(plugin.getBeaconTarget())) {
            plugin.getLogger().info("Won the game");
            plugin.startNewWorld();
        }
        
    }
    
    @EventHandler
    public void onBlockInteracted(PlayerInteractEvent event) {
        
        if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            return;
        }
        
        if (event.getClickedBlock().getLocation().equals(plugin.getBeaconLocation())) {
            plugin.getLogger().info("Beacon was interacted");
            onBeaconGrabbed(event);
        }
        
    }
    
    @EventHandler
    public void onItemThrown(PlayerDropItemEvent event) {
        
        event.setCancelled(true);
        
    }
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        
        if (event.getCurrentItem() == null) {
            return;
        }
        
        // Prevent armor slots and class picker modifications
        if (event.getSlotType().equals(InventoryType.SlotType.ARMOR) || event.getCurrentItem().isSimilar(ClassItemFactory.getClassPickerItem())) {
            event.setCancelled(true);
        }
        
        // Prevent putting stuff into chests, etc.
        if (event.getInventory().getType() != InventoryType.PLAYER) {
            event.setCancelled(true);
        }
        
    }
    
    public void onBeaconGrabbed(PlayerInteractEvent event) {
        
        Player player = event.getPlayer();
        CastleRaidPlayer crPlayer = plugin.getCrPlayers().get(player.getUniqueId());
        
        if (crPlayer == null) {
            return;
        }
        
        if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) && crPlayer.getTeam() == CastleRaidMain.teams.RED) {
            plugin.getLogger().info("Dude grabbed beacon");
            event.getClickedBlock().setType(Material.AIR);
            crPlayer.setCarriesBeacon(true);
        } else {
            event.setCancelled(true);
        }
        
    }
    
}