package com.github.koryu25.lifeworld.listener;

import com.github.koryu25.lifeworld.LWMain;
import com.github.koryu25.lifeworld.item.LWItem;
import com.github.koryu25.lifeworld.item.LWItemManager;
import com.github.koryu25.lifeworld.item.items.TestOreItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class LWBlockListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        Location loc = block.getLocation();

        if (block.getType() == Material.SPAWNER) {
            if (LWMain.placedCustomBlock.containsKey(loc)) {
                LWItem lwItem = LWMain.placedCustomBlock.get(loc);

                for (Entity entity : loc.getWorld().getNearbyEntities(loc, 2, 2, 2)) {
                    if (entity.getType() == EntityType.ITEM_FRAME) {
                        if (entity.getCustomName().equals(lwItem.name())) {
                            entity.remove();
                        }
                    }
                }

                LWItemManager lim = LWMain.getInstance().getLwItemManager();
                player.getInventory().addItem(lim.create(lwItem.dropItem()));

            }
        }
    }
}
