package com.github.koryu25.lifeworld;

import com.github.koryu25.lifeworld.block.LWBlock;
import com.github.koryu25.lifeworld.command.CommandManager;
import com.github.koryu25.lifeworld.data.LWBlockDataSet;
import com.github.koryu25.lifeworld.listener.ListenerManager;
import com.github.koryu25.lifeworld.data.mysql.MySQLManager;
import com.github.koryu25.lifeworld.player.LWPlayer;
import com.github.koryu25.lifeworld.yaml.MainConfig;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class LifeWorldMain extends JavaPlugin {

    private static JavaPlugin instance;

    // Data
    private static List<LWPlayer> lwPlayerList;

    @Override
    public void onEnable() {
        // instance
        instance = this;
        // yaml
        MainConfig.construct();
        // mysql
        MySQLManager.construct();
        // command
        new CommandManager(this);
        new ListenerManager(this);
        // data
        lwPlayerList = new ArrayList<>();
        LWBlockDataSet.onEnable();
    }

    @Override
    public void onDisable() {
        // LWBlock
        LWBlockDataSet.onDisable();
    }

    public static JavaPlugin getInstance() {
        return instance;
    }
}
