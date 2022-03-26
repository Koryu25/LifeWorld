package com.github.koryu25.lifeworld;

import com.github.koryu25.lifeworld.command.CommandManager;
import com.github.koryu25.lifeworld.data.LWBlockDataSet;
import com.github.koryu25.lifeworld.data.SqlDAO;
import com.github.koryu25.lifeworld.listener.ListenerManager;
import com.github.koryu25.lifeworld.yaml.MainConfig;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class LWMain extends JavaPlugin {

    private static LWMain instance;

    @Getter
    private MainConfig mainConfig;
    @Getter
    private SqlDAO sqlDAO;
    @Getter
    private LWBlockDataSet lwBlockDataSet;

    @Override
    public void onEnable() {
        // instance
        instance = this;
        // yaml
        mainConfig = new MainConfig();
        // mysql
        sqlDAO = new SqlDAO();
        // command
        new CommandManager(this);
        // event listener
        new ListenerManager(this);
        // data
        lwBlockDataSet = new LWBlockDataSet();
    }

    @Override
    public void onDisable() {
        // LWBlock
        lwBlockDataSet.onDisable();
    }

    public static LWMain getInstance() {
        return instance;
    }
}
