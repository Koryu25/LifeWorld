package com.github.koryu25.lifeworld.data;

import com.github.koryu25.lifeworld.block.LWBlock;
import com.github.koryu25.lifeworld.data.mysql.*;
import org.bukkit.block.Block;

import java.util.Set;

public class LWBlockDataSet {

    private static Set<LWBlock> set;

    private LWBlockDataSet() {
    }

    public static LWBlock search(Block block) {
        for (LWBlock lwBlock : set) {
            if (lwBlock.match(block)) return lwBlock;
        }
        return null;
    }

    public static void add(LWBlock lwBlock) {
        set.add(lwBlock);
    }
    public static void remove(LWBlock lwBlock) {
        set.remove(lwBlock);
    }

    public static void onEnable() {
        // load
        set = Select.allLWBlock();
    }

    public static void onDisable() {
        // lwBlock.onDisable()
        for (LWBlock lwBlock : set) {
            lwBlock.onDisable();
        }
        // save
        for (LWBlock lwBlock : set) {
            // 存在したらupdate
            // 存在しなかったらinsert
            if (Exists.lwBlock(lwBlock)) Update.lwBlock(lwBlock);
            else Insert.lwBlock(lwBlock);
        }
        // setに存在しなかったらdelete
        for (LWBlock lwBlock : Select.allLWBlock()) {
            if (!inSet(lwBlock)) {
                Delete.lwBlock(lwBlock);
            }
        }
    }

    // setの中に存在するか
    private static boolean inSet(LWBlock lwBlock) {
        for (LWBlock element : set) {
            if (lwBlock.match(element.getBlock())) return true;
        }
        return false;
    }
}
