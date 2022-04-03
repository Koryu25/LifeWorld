package com.github.koryu25.lifeworld.item;

import com.github.koryu25.lifeworld.item.items.TestOreItem;
import jdk.incubator.vector.VectorOperators;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LWItemManager {

    public final List<LWItem> items = new ArrayList<>();

    private final Material ITEM_FRAME = Material.ITEM_FRAME;

    public LWItemManager() {
        items.add(new TestOreItem());
    }

    public ItemStack create(LWItem lwItem) {
        ItemStack item = new ItemStack(ITEM_FRAME);
        if(item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(lwItem.name());
            meta.setCustomModelData(lwItem.CustomModelData());
            meta.setLore(lwItem.lore());
        }
        return item;
    }
}
