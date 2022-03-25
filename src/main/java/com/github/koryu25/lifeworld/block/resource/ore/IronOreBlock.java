package com.github.koryu25.lifeworld.block.resource.ore;

import com.github.koryu25.lifeworld.block.LWBlock;
import com.github.koryu25.lifeworld.block.resource.ResourceBlock;
import com.github.koryu25.lifeworld.item.LWItem;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class IronOreBlock extends LWBlock implements ResourceBlock {

    public IronOreBlock(Block block) {
        this(block.getX(), block.getY(), block.getZ());
    }
    public IronOreBlock(int x, int y, int z) {
        super(x, y, z, "IRON_ORE_BLOCK");
    }

    @Override
    public boolean whenBroken(Player player) {
        return ResourceBlock.super.whenBroken((LWBlock) this, player);
    }

    @Override
    public void onDisable() {
        ResourceBlock.super.onDisable(this);
    }

    @Override
    public Material getBroken() {
        return Material.COBBLESTONE;
    }

    @Override
    public LWItem getBlockItem() {
        return LWItem.IRON_ORE_RESOURCE_BLOCK;
    }

    @Override
    public LWItem getResourceItem() {
        return LWItem.IRON_ORE;
    }

    @Override
    public int getTime() {
        return 40;
    }
}
