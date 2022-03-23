package com.github.koryu25.lifeworld;

import com.github.koryu25.lifeworld.block.LWBlock;
import com.github.koryu25.lifeworld.command.CommandManager;
import com.github.koryu25.lifeworld.listener.ListenerManager;
import com.github.koryu25.lifeworld.mysql.MySQLManager;
import com.github.koryu25.lifeworld.player.LWPlayer;
import com.github.koryu25.lifeworld.yaml.MainConfig;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class LifeWorldMain extends JavaPlugin {

    private static JavaPlugin instance;

    private static MainConfig config;
    private static MySQLManager mySQLManager;

    // Data
    private static List<LWPlayer> lwPlayerList;
    private static Set<LWBlock> lwBlockSet;

    @Override
    public void onEnable() {
        instance = this;
        // yaml
        config = new MainConfig(this);
        // mysql
        /*
        mySQLManager = new MySQLManager(
                this,
                config.getHost(),
                config.getPort(),
                config.getDatabase(),
                config.getUsername(),
                config.getPassword()
        );
         */
        // command
        new CommandManager(this);
        new ListenerManager(this);
        // data
        lwPlayerList = new ArrayList<>();
        lwBlockSet = new HashSet<>();
    }

    @Override
    public void onDisable() {
        lwBlockSet.forEach(LWBlock::onDisable);
    }

    public static JavaPlugin getInstance() {
        return instance;
    }

    public static MainConfig getMainConfig() {
        return config;
    }
    public static MySQLManager getMySQLManager() {
        return mySQLManager;
    }

    public static LWBlock lwBlockSetOf(Block block) {
        for (LWBlock lwBlock : lwBlockSet) {
            if (lwBlock.match(block)) return lwBlock;
        }
        return null;
    }

    public static void addLWBlock(LWBlock lwBlock) {
        lwBlockSet.add(lwBlock);
    }
}
