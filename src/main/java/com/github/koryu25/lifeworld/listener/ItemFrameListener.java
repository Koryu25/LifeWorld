package com.github.koryu25.lifeworld.listener;

import com.github.koryu25.lifeworld.LWMain;
import com.github.koryu25.lifeworld.item.LWItem;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemFrameListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        PlayerInventory inv = player.getInventory();
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(inv.getItemInMainHand().getType() == Material.ITEM_FRAME
            || inv.getItemInOffHand().getType() == Material.ITEM_FRAME) {
                Location loc = e.getClickedBlock().getLocation();

                ItemStack item = inv.getItemInMainHand();

                if(item.hasItemMeta()) {
                    ItemMeta meta = item.getItemMeta();
                    int customModelData = meta.getCustomModelData();

                    boolean contains = LWMain.getInstance().getLwItemManager().contains(customModelData);

                    if(contains) {
                        inv.remove(item);

                        loc.getBlock().setType(Material.SPAWNER);
                        CreatureSpawner spawner = (CreatureSpawner) loc.getBlock().getState();
                        spawner.setDelay(0);
                        spawner.setMaxSpawnDelay(0);
                        spawner.setMinSpawnDelay(0);
                        spawner.setSpawnCount(0);
                        spawner.setSpawnRange(0);
                        NBTEditor.NBTCompound compound = NBTEditor.getNBTCompound(spawner);

                    }
                }
            }
        }
    }

}
