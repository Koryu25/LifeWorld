package com.github.koryu25.lifeworld.item;

import java.util.List;

public interface LWItem {
    String name();
    int CustomModelData();
    List<String> lore();

    LWItem dropItem();

    //設置できるか
    boolean canPlace();
}
