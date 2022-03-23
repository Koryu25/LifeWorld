package com.github.koryu25.lifeworld.item;

import com.github.koryu25.lifeworld.item.block.IronOrePlaceableBlock;
import com.github.koryu25.lifeworld.item.resource.ore.IronOre;
import com.github.koryu25.lifeworld.item.tool.ResourceDisassembler;
import org.bukkit.inventory.ItemStack;

public class LWItemManager {
    // Resource
    // Block
    public static final IronOrePlaceableBlock IRON_ORE_RESOURCE_BLOCK = new IronOrePlaceableBlock();
    // Ore
    public static final IronOre IRON_ORE = new IronOre();
    // Tool
    public static final ResourceDisassembler RESOURCE_DISASSEMBLER = new ResourceDisassembler();

    public static LWItem resource(ItemStack itemStack) {
        if (IRON_ORE_RESOURCE_BLOCK.match(itemStack)) return IRON_ORE_RESOURCE_BLOCK;
        return null;
    }
}
