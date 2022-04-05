package com.github.koryu25.lifeworld;

import com.github.koryu25.lifeworld.command.CommandManager;
import com.github.koryu25.lifeworld.listener.ListenerManager;
import org.bukkit.plugin.java.JavaPlugin;

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
