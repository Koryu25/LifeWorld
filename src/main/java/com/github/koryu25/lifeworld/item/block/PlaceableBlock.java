package com.github.koryu25.lifeworld.item.block;

import com.github.koryu25.lifeworld.block.LWBlock;
import org.bukkit.block.Block;

public interface PlaceableBlock {

    LWBlock getPlaceBlock(Block block);
}
