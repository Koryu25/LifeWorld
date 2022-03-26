package com.github.koryu25.lifeworld.data;

import com.github.koryu25.lifeworld.LWMain;
import com.github.koryu25.lifeworld.block.LWBlock;
import org.bukkit.block.Block;

import java.util.Set;

public class LWBlockDataSet {

    private Set<LWBlock> set;

    public LWBlockDataSet() {
        set = LWMain.getInstance().getSqlDAO().getAllBlockData();
    }

    public LWBlock search(Block block) {
        for (LWBlock lwBlock : set) {
            if (lwBlock.match(block)) return lwBlock;
        }
        return null;
    }

    public void add(LWBlock lwBlock) {
        set.add(lwBlock);
    }
    public void remove(LWBlock lwBlock) {
        set.remove(lwBlock);
    }


    public void onDisable() {
        // lwBlock.onDisable()
        for (LWBlock lwBlock : set) {
            lwBlock.onDisable();
        }
        // save
        for (LWBlock lwBlock : set) {
            // 存在したらupdate
            // 存在しなかったらinsert
            if (LWMain.getInstance().getSqlDAO().isExistBlockData(lwBlock)) {
                LWMain.getInstance().getSqlDAO().updateBlockData(lwBlock);
            } else {
                LWMain.getInstance().getSqlDAO().insertBlockData(lwBlock);
            }
        }
        // setに存在しなかったらdelete
        for (LWBlock lwBlock : LWMain.getInstance().getSqlDAO().getAllBlockData()) {
            if (!inSet(lwBlock)) {
                LWMain.getInstance().getSqlDAO().deleteBlockData(lwBlock);
            }
        }
    }

    // setの中に存在するか
    private boolean inSet(LWBlock lwBlock) {
        for (LWBlock element : set) {
            if (lwBlock.match(element.getBlock())) return true;
        }
        return false;
    }
}
