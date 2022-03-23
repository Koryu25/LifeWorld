package com.github.koryu25.lifeworld.block;

import com.github.koryu25.lifeworld.LifeWorldMain;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class LWBlock {

    public final int x;
    public final int y;
    public final int z;
    protected Material material;

    public LWBlock(int x, int y, int z, Material material) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.material = material;
    }

    public Block getBlock() {
        return Bukkit.getWorld(LifeWorldMain.getMainConfig().getMainWorld()).getBlockAt(x, y, z);
    }
    public void setBlock(Material material) {
        getBlock().setType(material);
    }

    public boolean match(Block block) {
        return this.x == block.getX() && this.y == block.getY() && this.z == block.getZ();
    }

    // 壊されたときの処理
    public abstract boolean whenBroken(Player player);

    // プラグインが終了するときの処理
    public abstract void onDisable();
}
