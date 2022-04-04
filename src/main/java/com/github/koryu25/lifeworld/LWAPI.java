package com.github.koryu25.lifeworld;

import com.github.koryu25.lifeworld.item.LWItemManager;
import com.github.koryu25.lifeworld.util.InventoryUtil;

public enum LWAPI {

    INSTANCE;

    private LWItemManager lwItemManager;


    public static LWAPI getInstance() {
        if(INSTANCE.lwItemManager == null) {
            INSTANCE.lwItemManager = new LWItemManager();
        }

        return INSTANCE;
    }

    public LWItemManager getLwItemManager() {
        return lwItemManager;
    }

}
