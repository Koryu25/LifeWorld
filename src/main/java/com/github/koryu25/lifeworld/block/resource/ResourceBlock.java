package com.github.koryu25.lifeworld.block.resource;

import com.github.koryu25.lifeworld.LifeWorldMain;
import com.github.koryu25.lifeworld.block.LWBlock;
import com.github.koryu25.lifeworld.block.resource.ore.IronOreBlock;
import com.github.koryu25.lifeworld.data.LWBlockDataSet;
import com.github.koryu25.lifeworld.item.LWItem;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public interface ResourceBlock {

    default Material getOriginal() {
        return getBlockItem().getMaterial();
    }

    Material getBroken();

    LWItem getBlockItem();

    LWItem getResourceItem();

    int getTime();

    default boolean whenBroken(LWBlock lwBlock, Player player) {
        Block block = lwBlock.getBlock();
        // インターバル中だった時の処理
        if (block.getType() == getBroken()) return true;
        // 道具が資源ブロック分解器だった時の処理
        if (LWItem.RESOURCE_DISASSEMBLER.match(player.getInventory().getItemInMainHand())) {
            block.getWorld().dropItem(block.getLocation(), getBlockItem().toItemStack());
            lwBlock.remove();
            return false;
        }
        // ブロックの変更
        lwBlock.setBlock(getBroken());
        new BukkitRunnable() {
            @Override
            public void run() {
                lwBlock.setBlock(getOriginal());
            }
        }.runTaskLater(LifeWorldMain.getInstance(), getTime());
        // アイテムのドロップ
        lwBlock.dropItem(getResourceItem().toItemStack());
        return true;
    }

    default void onDisable(LWBlock lwBlock) {
        if (getOriginal() != lwBlock.getBlock().getType()) lwBlock.setBlock(getOriginal());
    }

    static ResourceBlock instance(Block block, String name) {
        return instance(block.getX(), block.getY(), block.getZ(),name);
    }
    static ResourceBlock instance(int x, int y, int z, String name) {
        return switch (name) {
            case "IronOreBlock" -> new IronOreBlock(x, y, z);
            default -> null;
        };
    }
}
