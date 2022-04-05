package com.github.koryu25.lifeworld.listener;

import com.github.koryu25.lifeworld.LWAPI;
import com.github.koryu25.lifeworld.item.LWItem;
import com.github.koryu25.lifeworld.item.LWItemManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExpEvent;

public class LWBlockListener implements Listener {

    //ブロック破壊に関する処理
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        Location loc = block.getLocation();

        if (block.getType() == Material.SPAWNER) {

            for (Entity entity : loc.getWorld().getNearbyEntities(loc, 2, 2, 2)) {
                if (entity.getType() == EntityType.ITEM_FRAME) {
                    LWItemManager lim = LWAPI.getInstance().getLwItemManager();

                    for (String name : lim.getCustomItemNames()) {
                        if (entity.getCustomName().equals(name)) {
                            LWItem lwItem = lim.getItemFromName(name);
                            player.getInventory().addItem(lim.create(lwItem.dropItem()));
                        }
                    }

                }
            }
        }
    }

    //経験値に関する処理
    @EventHandler
    public void onBlockExp(BlockExpEvent e) {
        Block block = e.getBlock();
        Location loc = block.getLocation();

        if (block.getType() == Material.SPAWNER) {

            for (Entity entity : loc.getWorld().getNearbyEntities(loc, 2, 2, 2)) {
                if (entity.getType() == EntityType.ITEM_FRAME) {
                    LWItemManager lim = LWAPI.getInstance().getLwItemManager();

                    for (String name : lim.getCustomItemNames()) {
                        if (entity.getCustomName().equals(name)) {
                            entity.remove();//経験値を落とすタイミングで、額縁を削除する

                            LWItem lwItem = lim.getItemFromName(name);

                            e.setExpToDrop(lwItem.exp());

                        }
                    }

                }
            }
        }
    }
}
