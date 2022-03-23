package com.github.koryu25.lifeworld.block.resource.ore;

import com.github.koryu25.lifeworld.block.resource.ResourceBlock;
import com.github.koryu25.lifeworld.item.LWItemManager;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class IronOreBlock extends ResourceBlock {

    public IronOreBlock(Block block) {
        this(block, 40);
    }
    public IronOreBlock(Block block, int interval) {
        super(block.getX(), block.getY(), block.getZ(),
                LWItemManager.IRON_ORE_RESOURCE_BLOCK,
                LWItemManager.IRON_ORE,
                Material.COBBLESTONE,
                interval
        );
    }
}
