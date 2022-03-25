package com.github.koryu25.lifeworld.item.placeable;

import com.github.koryu25.lifeworld.block.LWBlock;
import org.bukkit.block.Block;

public interface PlaceableItem {

    LWBlock getPlaceBlock(Block block);
}
