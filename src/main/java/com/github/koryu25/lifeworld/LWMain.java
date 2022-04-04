package com.github.koryu25.lifeworld;

import com.github.koryu25.lifeworld.command.CommandManager;
import com.github.koryu25.lifeworld.item.LWItem;
import com.github.koryu25.lifeworld.item.LWItemManager;
import com.github.koryu25.lifeworld.listener.ListenerManager;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class LWMain extends JavaPlugin {

    @Override
    public void onEnable() {
        //Listeners
        ListenerManager lm = new ListenerManager(this);

        //command
        getServer().getPluginCommand("lw").setExecutor(new CommandManager());
    }

    @Override
    public void onDisable() {
    }
}
