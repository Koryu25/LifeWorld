package com.github.koryu25.lifeworld.listener;

import com.github.koryu25.lifeworld.listener.listeners.BlockBreakPlaceListener;
import com.github.koryu25.lifeworld.listener.listeners.JoinQuitListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ListenerManager {

    private final JavaPlugin main;

    public ListenerManager(JavaPlugin main) {
        this.main = main;
        register(new JoinQuitListener());
        register(new BlockBreakPlaceListener());
    }

    public void register(Listener listener) {
        main.getServer().getPluginManager().registerEvents(listener, main);
    }
}
