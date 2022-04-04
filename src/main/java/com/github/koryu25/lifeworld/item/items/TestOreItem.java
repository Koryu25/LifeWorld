package com.github.koryu25.lifeworld.item.items;

import com.github.koryu25.lifeworld.item.LWItem;

import java.util.List;

public class TestOreItem implements LWItem {
    @Override
    public String name() {
        return "TestOreItem";
    }

    @Override
    public int CustomModelData() {
        return 1;
    }

    @Override
    public List<String> lore() {
        return List.of(
                "テストの",
                "アイテムです");
    }

    @Override
    public LWItem dropItem() {
        return this;
    }

    @Override
    public boolean canPlace() {
        return true;
    }


}
