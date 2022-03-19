package com.github.koryu25.lifeworld;

import com.github.koryu25.lifeworld.mysql.MySQLManager;
import com.github.koryu25.lifeworld.yaml.MainConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class LifeWorldMain extends JavaPlugin {

    public static MainConfig config;
    public static MySQLManager mySQLManager;

    @Override
    public void onEnable() {
        config = new MainConfig(this);
        mySQLManager = new MySQLManager(
                this,
                config.getHost(),
                config.getPort(),
                config.getDatabase(),
                config.getUsername(),
                config.getPassword()
        );
    }

    @Override
    public void onDisable() {
    }
}
