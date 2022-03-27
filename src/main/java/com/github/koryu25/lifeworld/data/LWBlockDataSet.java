package com.github.koryu25.lifeworld.data;

import com.github.koryu25.lifeworld.LWMain;
import com.github.koryu25.lifeworld.block.LWBlock;
import org.bukkit.block.Block;

import java.util.Set;

public class LWBlockDataSet {

    private Set<LWBlock> blockDataSet;

    public LWBlockDataSet() {
        // load
        SqlDAO dao = LWMain.getInstance().getDao();
        blockDataSet = dao.getAllBlockData();
    }

    public LWBlock search(Block block) {
        for (LWBlock lwBlock : blockDataSet) {
            if (lwBlock.match(block)) return lwBlock;
        }
        return null;
    }

    public void add(LWBlock lwBlock) {
        blockDataSet.add(lwBlock);
    }
    public void remove(LWBlock lwBlock) {
        blockDataSet.remove(lwBlock);
    }

    // setの中に存在するか
    private boolean inSet(LWBlock lwBlock) {
        for (LWBlock element : blockDataSet) {
            if (lwBlock.match(element.getBlock())) return true;
        }
        return false;
    }
}
