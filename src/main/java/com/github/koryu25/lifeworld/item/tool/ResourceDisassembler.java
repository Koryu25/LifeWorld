package com.github.koryu25.lifeworld.item.tool;

import com.github.koryu25.lifeworld.item.ItemType;
import com.github.koryu25.lifeworld.item.LWItem;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class ResourceDisassembler implements LWItem {
    @Override
    public ItemType getType() {
        return ItemType.TOOL;
    }

    @Override
    public Material getMaterial() {
        return Material.WOODEN_PICKAXE;
    }

    @Override
    public String getName() {
        return "資源ブロック分解器";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§d資源ブロックを回収できる", "現在テスト中");
    }
}
