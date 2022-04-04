package com.github.koryu25.lifeworld.item;

import java.util.List;

public interface LWItem {
    //アイテム名
    String name();

    //カスタムモデルデータ
    int CustomModelData();

    //lore
    List<String> lore();

    //取得するアイテム
    LWItem dropItem();

    //設置できるか
    boolean canPlace();

    //取得できるEXP量
    int exp();
}
