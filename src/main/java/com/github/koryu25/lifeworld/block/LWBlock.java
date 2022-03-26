package com.github.koryu25.lifeworld.block;

import com.github.koryu25.lifeworld.LWMain;
import com.github.koryu25.lifeworld.block.resource.ore.IronOreBlock;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class LWBlock {

    public final int x;
    public final int y;
    public final int z;
    public final String kind;

    public LWBlock(Block block, String kind) {
        this(block.getX(), block.getY(), block.getZ(), kind);
    }
    public LWBlock(int x, int y, int z, String kind) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.kind = kind;
    }

    public void dropItem(ItemStack itemStack) {
        getBlock().getWorld().dropItem(getBlock().getLocation(), itemStack);
    }

    public Block getBlock() {
        return Bukkit.getWorld(LWMain.getInstance().getMainConfig().getMainWorld()).getBlockAt(x, y, z);
    }
    public void setBlock(Material material) {
        getBlock().setType(material);
    }

    public boolean match(Block block) {
        return this.x == block.getX() && this.y == block.getY() && this.z == block.getZ();
    }

    public void add() {
        LWMain.getInstance().getLwBlockDataSet().add(this);
    }
    public void remove() {
        LWMain.getInstance().getLwBlockDataSet().remove(this);
    }

    // 壊されたときの処理
    public abstract boolean whenBroken(Player player);

    // プラグインが終了するときの処理
    public abstract void onDisable();

    public static LWBlock of(String name, int x, int y, int z) {
        switch (name) {
            case IronOreBlock.KIND:
                return new IronOreBlock(x, y, z);
            default:
                return null;
        }
    }
}
