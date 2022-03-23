package com.github.koryu25.lifeworld.item.block;

import com.github.koryu25.lifeworld.block.LWBlock;
import com.github.koryu25.lifeworld.block.resource.ore.IronOreBlock;
import com.github.koryu25.lifeworld.item.ItemType;
import com.github.koryu25.lifeworld.item.LWItem;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.Arrays;
import java.util.List;

public class IronOrePlaceableBlock implements LWItem, PlaceableBlock {
    @Override
    public ItemType getType() {
        return ItemType.RESOURCE_BLOCK;
    }

    @Override
    public Material getMaterial() {
        return Material.IRON_ORE;
    }

    @Override
    public String getName() {
        return "ふつうの鉄鉱石資源ブロック";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§fふつうの鉄鉱石の資源ブロック。", "§fこのブロックを破壊すると、", "§fふつうの鉄鉱石が手に入る。");
    }

    @Override
    public LWBlock getPlaceBlock(Block block) {
        return new IronOreBlock(block);
    }
}
