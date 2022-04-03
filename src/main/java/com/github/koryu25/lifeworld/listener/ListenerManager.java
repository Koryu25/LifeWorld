package com.github.koryu25.lifeworld.listener;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class ListenerManager {

    private JavaPlugin plugin;

    private List<Listener> listeners = new ArrayList<>();

    public ListenerManager(JavaPlugin plugin) {
        this.plugin = plugin;

        listeners.add(new ItemFrameListener());
        listeners.add(new LWBlockListener());

        register();
    }

    private void register() {
        for(Listener l : listeners) {
            plugin.getServer().getPluginManager().registerEvents(l, plugin);
        }
    }
}
