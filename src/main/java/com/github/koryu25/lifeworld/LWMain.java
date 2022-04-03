package com.github.koryu25.lifeworld;

import com.github.koryu25.lifeworld.item.LWItemManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class LWMain extends JavaPlugin {

    private static LWMain instance;

    @Getter
    public LWItemManager lwItemManager;

    @Override
    public void onEnable() {
        // instance
        instance = this;

        lwItemManager = new LWItemManager();
    }

    @Override
    public void onDisable() {
    }

    public static LWMain getInstance() {
        return instance;
    }
}
