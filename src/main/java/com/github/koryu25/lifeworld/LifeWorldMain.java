package com.github.koryu25.lifeworld;

import com.github.koryu25.lifeworld.command.CommandManager;
import com.github.koryu25.lifeworld.data.LWBlockDataSet;
import com.github.koryu25.lifeworld.data.SqlDAO;
import com.github.koryu25.lifeworld.listener.ListenerManager;
import com.github.koryu25.lifeworld.player.LWPlayer;
import com.github.koryu25.lifeworld.yaml.MainConfig;
import com.sun.tools.javac.Main;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class LifeWorldMain extends JavaPlugin {

    private static LifeWorldMain instance;

    //sql
    @Getter
    private SqlDAO dao;
    //config
    @Getter
    private MainConfig mainConfig;

    // Data
    private static List<LWPlayer> lwPlayerList;

    @Override
    public void onEnable() {
        // instance
        instance = this;
        //sql
        dao = new SqlDAO();
        // yaml
        mainConfig = new MainConfig();
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

    public static LifeWorldMain getInstance() {
        return instance;
    }
}
