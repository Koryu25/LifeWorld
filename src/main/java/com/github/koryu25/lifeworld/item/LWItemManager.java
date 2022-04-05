package com.github.koryu25.lifeworld.item;

import com.github.koryu25.lifeworld.item.items.TestOreItem;
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

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(lwItem.name());
        meta.setCustomModelData(lwItem.CustomModelData());
        meta.setLore(lwItem.lore());
        item.setItemMeta(meta);

        return item;
    }

    public boolean contains(int customModelData) {
        boolean result = false;

        for (LWItem item : items) {
            if (item.CustomModelData() == customModelData) {
                result = true;
                break;
            }
        }

        return result;
    }

    public List<String> getCustomItemNames() {
        List<String> strs = new ArrayList<>();
        for(LWItem lwItem : items) {
            strs.add(lwItem.name());
        }

        return strs;
    }
    public LWItem getItemFromName(String name) {
        LWItem item = null;

        for(LWItem lwItem : items) {
            if(lwItem.name().equals(name)) {
                item = lwItem;
                break;
            }
        }

        return item;
    }


}
