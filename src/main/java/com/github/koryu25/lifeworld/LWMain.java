package com.github.koryu25.lifeworld;

import org.bukkit.plugin.java.JavaPlugin;

public final class LWMain extends JavaPlugin {

    private static LWMain instance;

    @Override
    public void onEnable() {
        // instance
        instance = this;
    }

    @Override
    public void onDisable() {
    }

    public static LWMain getInstance() {
        return instance;
    }
}
