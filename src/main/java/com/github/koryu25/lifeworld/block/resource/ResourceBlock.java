package com.github.koryu25.lifeworld.block.resource;

import com.github.koryu25.lifeworld.LifeWorldMain;
import com.github.koryu25.lifeworld.block.LWBlock;
import com.github.koryu25.lifeworld.item.LWItem;
import com.github.koryu25.lifeworld.item.LWItemManager;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ResourceBlock extends LWBlock {

    private final Material broken;
    private LWItem blockItem;
    private LWItem resourceItem;
    @Getter @Setter
    private int interval;

    public ResourceBlock(int x, int y, int z, LWItem blockItem, LWItem resourceItem, Material broken, int interval) {
        super(x, y, z, blockItem.getMaterial());
        this.blockItem = blockItem;
        this.resourceItem = resourceItem;
        this.broken = broken;
        this.interval = interval;
    }

    @Override
    public boolean whenBroken(Player player) {
        Block block = getBlock();
        // interval中だった時の処理
        if (block.getType() == broken) return true;
        // handの確認
        if (LWItemManager.RESOURCE_DISASSEMBLER.match(player.getInventory().getItemInMainHand())) {
            block.getWorld().dropItem(getBlock().getLocation(), blockItem.toItemStack());
            return false;
        }
        // ブロックの変更
        setBlock(broken);
        new BukkitRunnable() {
            @Override
            public void run() {
                setBlock(material);
            }
        }.runTaskLater(LifeWorldMain.getInstance(), interval);
        // アイテムのドロップ
        block.getWorld().dropItem(block.getLocation(), resourceItem.toItemStack());
        return true;
    }

    @Override
    public void onDisable() {
        if (material != getBlock().getType()) setBlock(material);
    }
}
