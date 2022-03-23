package com.github.koryu25.lifeworld.item.resource.ore;

import com.github.koryu25.lifeworld.item.ItemType;
import com.github.koryu25.lifeworld.item.LWItem;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class IronOre implements LWItem {

    @Override
    public ItemType getType() {
        return ItemType.RESOURCE;
    }

    @Override
    public Material getMaterial() {
        return Material.IRON_ORE;
    }

    @Override
    public String getName() {
        return "鉄鉱石";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§fふつうの鉄鉱石。");
    }
}
