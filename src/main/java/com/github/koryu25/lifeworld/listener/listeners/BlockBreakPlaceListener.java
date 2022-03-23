package com.github.koryu25.lifeworld.listener.listeners;

import com.github.koryu25.lifeworld.LifeWorldMain;
import com.github.koryu25.lifeworld.block.LWBlock;
import com.github.koryu25.lifeworld.block.resource.ore.IronOreBlock;
import com.github.koryu25.lifeworld.item.LWItem;
import com.github.koryu25.lifeworld.item.LWItemManager;
import com.github.koryu25.lifeworld.item.block.PlaceableBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakPlaceListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        LWBlock lwBlock = LifeWorldMain.lwBlockSetOf(event.getBlock());
        // LWBlockだった時の処理
        if (lwBlock != null) {
            event.setDropItems(false);
            event.setCancelled(lwBlock.whenBroken(event.getPlayer()));
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        // ResourceBlockだった時の処理
        LWItem lwItem = LWItemManager.resource(event.getItemInHand());
        if (lwItem instanceof PlaceableBlock placeableBlock) {
            LWBlock lwBlock = placeableBlock.getPlaceBlock(event.getBlock());
            if (lwBlock == null) return;
            LifeWorldMain.addLWBlock(lwBlock);
        }
    }
}
