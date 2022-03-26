package com.github.koryu25.lifeworld.block.resource.ore;

import com.github.koryu25.lifeworld.block.LWBlock;
import com.github.koryu25.lifeworld.block.resource.ResourceBlock;
import com.github.koryu25.lifeworld.item.LWItem;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class IronOreBlock extends ResourceBlock {

    public static final String KIND = "IronOreBlock";

    public IronOreBlock(Block block) {
        super(block, KIND);
    }

    public IronOreBlock(int x, int y, int z) {
        super(x, y, z, KIND);
    }

    @Override
    public boolean whenBroken(Player player) {
        return whenBroken((LWBlock) this, player);
    }

    @Override
    public void onDisable() {
        super.onDisable(this);
    }

    @Override
    protected Material getBroken() {
        return Material.COBBLESTONE;
    }

    @Override
    protected LWItem getBlockItem() {
        return LWItem.IRON_ORE_RESOURCE_BLOCK;
    }

    @Override
    protected LWItem getResourceItem() {
        return LWItem.IRON_ORE;
    }

    @Override
    protected int getTime() {
        return 40;
    }
}
