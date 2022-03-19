package com.github.koryu25.lifeworld.yaml;

import org.bukkit.plugin.java.JavaPlugin;

public final class MainConfig extends CustomConfig {

    public MainConfig(JavaPlugin main) {
        super(main, "config.yml");
    }

    // MySQL
    public String getHost() {
        return getConfig().getString("mysql.host", "host");
    }
    public int getPort() {
        return getConfig().getInt("mysql.port", 3306);
    }
    public String getDatabase() {
        return getConfig().getString("mysql.database", "life");
    }
    public String getUsername() {
        return getConfig().getString("mysql.username", "root");
    }
    public String getPassword() {
        return getConfig().getString("mysql.password", null);
    }
}
