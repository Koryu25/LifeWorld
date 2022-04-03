package com.github.koryu25.lifeworld;

import com.github.koryu25.lifeworld.command.CommandManager;
import com.github.koryu25.lifeworld.data.LWBlockDataSet;
import com.github.koryu25.lifeworld.data.SqlDAO;
import com.github.koryu25.lifeworld.listener.ListenerManager;
import com.github.koryu25.lifeworld.player.LWPlayer;
import com.github.koryu25.lifeworld.yaml.MainConfig;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

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
