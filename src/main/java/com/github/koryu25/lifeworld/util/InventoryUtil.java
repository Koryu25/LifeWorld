package com.github.koryu25.lifeworld.util;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

//インベントリ操作に便利なメソッドをまとめたクラス
public class InventoryUtil {

    private Inventory inv;

    public InventoryUtil(Inventory inv) {
        this.inv = inv;
    }

    //アイテム数を１だけ減らすメソッド
    public void decItemAmount(ItemStack item) {
        if(inv.contains(item.getType())) {
            ItemStack foundItem = inv.getItem(inv.first(item.getType()));

            if(item.hasItemMeta() && foundItem.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                ItemMeta foundMeta = foundItem.getItemMeta();

                if(meta.getDisplayName().equals(foundMeta.getDisplayName())) {
                    if(foundItem.getAmount() > 1) {
                        foundItem.setAmount(foundItem.getAmount() - 1);
                    }else {
                        inv.remove(foundItem);
                    }
                }
            } else {
                if(foundItem.getAmount() > 1) {
                    foundItem.setAmount(foundItem.getAmount() - 1);
                } else {
                    inv.remove(foundItem);
                }
            }
        }
    }
}
