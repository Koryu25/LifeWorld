package com.github.koryu25.lifeworld;

import com.github.koryu25.lifeworld.command.CommandManager;
import com.github.koryu25.lifeworld.item.LWItemManager;
import com.github.koryu25.lifeworld.listener.ListenerManager;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class LWMain extends JavaPlugin {

    private static LWMain instance;

    @Getter
    public LWItemManager lwItemManager;

    @Override
    public void onEnable() {
        // instance
        instance = this;

        //LWItems
        lwItemManager = new LWItemManager();

        //Listeners
        ListenerManager lm = new ListenerManager(this);

        //command
        getServer().getPluginCommand("lw").setExecutor(new CommandManager());
    }

    @Override
    public void onDisable() {
    }

    public static LWMain getInstance() {
        return instance;
    }
}
