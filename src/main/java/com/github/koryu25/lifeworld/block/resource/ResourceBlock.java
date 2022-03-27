package com.github.koryu25.lifeworld.block.resource;

import com.github.koryu25.lifeworld.LWMain;
import com.github.koryu25.lifeworld.block.LWBlock;
import com.github.koryu25.lifeworld.item.LWItem;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class ResourceBlock extends LWBlock {

    public ResourceBlock(Block block, String kind) {
        super(block, kind);
    }

    public ResourceBlock(int x, int y, int z, String kind) {
        super(x, y, z, kind);
    }

    protected Material getOriginal() {
        return getBlockItem().getMaterial();
    }

    protected abstract Material getBroken();

    protected abstract LWItem getBlockItem();

    protected abstract LWItem getResourceItem();

    protected abstract int getTime();

    protected boolean whenBroken(LWBlock lwBlock, Player player) {
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
        }.runTaskLater(LWMain.getInstance(), getTime());
        // アイテムのドロップ
        lwBlock.dropItem(getResourceItem().toItemStack());
        return true;
    }

}
