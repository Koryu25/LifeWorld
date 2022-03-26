package com.github.koryu25.lifeworld.data;

import com.github.koryu25.lifeworld.LifeWorldMain;
import com.github.koryu25.lifeworld.block.LWBlock;
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
        SqlDAO dao = LifeWorldMain.getInstance().getDao();
        set = dao.getAllBlockData();
    }

    public static void onDisable() {
        SqlDAO dao = LifeWorldMain.getInstance().getDao();
        // lwBlock.onDisable()
        for (LWBlock lwBlock : set) {
            lwBlock.onDisable();
        }
        // save
        for (LWBlock lwBlock : set) {
            // 存在したらupdate
            // 存在しなかったらinsert
            if (dao.isExistBlockData(lwBlock)) {
                dao.updateBlockData(lwBlock);
            } else {
                dao.insertBlockData(lwBlock);
            }
        }
        // setに存在しなかったらdelete
        for (LWBlock lwBlock : dao.getAllBlockData()) {
            if (!inSet(lwBlock)) {
                dao.deleteBlockData(lwBlock);
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
