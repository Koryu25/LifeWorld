package com.github.koryu25.lifeworld.listener.listeners;

import com.github.koryu25.lifeworld.LWMain;
import com.github.koryu25.lifeworld.block.LWBlock;
import com.github.koryu25.lifeworld.item.LWItem;
import com.github.koryu25.lifeworld.item.placeable.PlaceableItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import org.bukkit.event.block.BlockPlaceEvent;

public class BlockBreakPlaceListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        // lwBrockが存在するか
        LWBlock lwBlock = LWMain.getInstance().getLwBlockDataSet().search(event.getBlock());
        if (lwBlock != null) {
            // 壊れたときの処理
            event.setCancelled(lwBlock.whenBroken(event.getPlayer()));
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        // アイテムがLWItemであるか
        LWItem lwItem = LWItem.getResourceItem(event.getItemInHand());
        if (lwItem != null) {
            // lwItemがPlaceableであるか
            if (lwItem instanceof PlaceableItem placeableItem) {
                // lwItemを設置
                // lwBlockをデータに追加
                placeableItem.getPlaceBlock(event.getBlock()).add();
            }
        }
    }
}
