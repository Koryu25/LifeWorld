package com.github.koryu25.lifeworld.listener;

import com.github.koryu25.lifeworld.LWAPI;
import com.github.koryu25.lifeworld.item.LWItem;
import com.github.koryu25.lifeworld.util.InventoryUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemFrameListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        PlayerInventory inv = player.getInventory();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (inv.getItemInMainHand().getType() == Material.ITEM_FRAME
                    || inv.getItemInOffHand().getType() == Material.ITEM_FRAME) {
                Location loc = e.getClickedBlock().getLocation();

                ItemStack item = inv.getItemInMainHand();

                if (item.hasItemMeta()) {
                    ItemMeta meta = item.getItemMeta();
                    int customModelData = meta.getCustomModelData();
                    String CustomName = meta.getDisplayName();

                    boolean contains = LWAPI.getInstance().getLwItemManager().contains(customModelData);

                    if (contains) {
                        e.setCancelled(true);

                        LWItem lwItem = LWAPI.getInstance().getLwItemManager().getItemFromName(CustomName);
                        if(!lwItem.canPlace()) return;

                        InventoryUtil invUtil = new InventoryUtil(inv);
                        invUtil.decItemAmount(item);

                        //スポナーの設置
                        Location blockLoc = loc.clone().add(0, 1, 0);

                        ItemFrame itemFrame = (ItemFrame) player.getWorld().spawnEntity(blockLoc, EntityType.ITEM_FRAME);
                        itemFrame.setFacingDirection(BlockFace.UP);
                        itemFrame.setFixed(true);
                        itemFrame.setVisible(false);
                        itemFrame.setInvulnerable(true);
                        itemFrame.setSilent(true);
                        itemFrame.setCustomName(CustomName);

                        ItemStack frame = new ItemStack(Material.ITEM_FRAME);
                        ItemMeta frameMeta = frame.getItemMeta();
                        frameMeta.setCustomModelData(customModelData);
                        frame.setItemMeta(frameMeta);
                        itemFrame.setItem(frame);

                        blockLoc.getBlock().setType(Material.SPAWNER);
                        CreatureSpawner spawner = (CreatureSpawner) blockLoc.getBlock().getState();
                        spawner.setSpawnedType(EntityType.AREA_EFFECT_CLOUD);
                        spawner.setDelay(0);
                        spawner.setMinSpawnDelay(0);
                        spawner.setSpawnCount(0);
                        spawner.setSpawnRange(0);

                    }
                }
            }
        }
    }
}
