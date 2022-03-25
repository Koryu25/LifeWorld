package com.github.koryu25.lifeworld.item;

import com.github.koryu25.lifeworld.item.placeable.resource.ore.IronOrePlaceableItem;
import com.github.koryu25.lifeworld.item.resource.ore.IronOre;
import com.github.koryu25.lifeworld.item.tool.ResourceDisassembler;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public interface LWItem {

    String PREFIX = "§f<<<";
    String SUFFIX = "§f>>>";
    String DESCRIPTION = " §edescription ";
    String TYPE = "type";

    ItemType getType();

    Material getMaterial();

    String getName();

    List<String> getDescription();

    default List<String> getLore() {
        List<String> lore = new ArrayList<>();
        lore.add(PREFIX + DESCRIPTION + SUFFIX);
        lore.addAll(getDescription());
        lore.add("§f" + TYPE + ": " + getType().getLabel());
        return lore;
    }

    default ItemStack toItemStack() {
        ItemStack itemStack = new ItemStack(getMaterial());
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(getName());
        itemMeta.setLore(getLore());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    default boolean match(ItemStack itemStack) {
        // null
        if (itemStack == null) return false;
        // itemMeta
        if (!itemStack.hasItemMeta()) return false;
        // material
        if (getMaterial() != itemStack.getType()) return false;
        ItemMeta itemMeta = itemStack.getItemMeta();
        // name
        if (!itemMeta.getDisplayName().equals(getName())) return false;
        // lore
        List<String> lore = getLore();
        if (lore.size() != itemMeta.getLore().size()) return false;
        for (int i = 0; i < lore.size(); i++) {
            if (!lore.get(i).equals(itemMeta.getLore().get(i))) return false;
        }
        return true;
    }

    // static
    // Resource
    // Block
    IronOrePlaceableItem IRON_ORE_RESOURCE_BLOCK = new IronOrePlaceableItem();
    // Ore
    IronOre IRON_ORE = new IronOre();
    // Tool
    ResourceDisassembler RESOURCE_DISASSEMBLER = new ResourceDisassembler();

    static LWItem getResourceItem(ItemStack itemStack) {
        if (IRON_ORE_RESOURCE_BLOCK.match(itemStack)) return IRON_ORE_RESOURCE_BLOCK;
        return null;
    }

    static LWItem of(String name) {
        switch (name) {
            case "IRON_ORE_RESOURCE_BLOCK":
                return IRON_ORE_RESOURCE_BLOCK;
            case "IRON_ORE":
                return IRON_ORE;
            case "RESOURCE_DISASSEMBLER":
                return RESOURCE_DISASSEMBLER;
        }
        return null;
    }
}
