package com.github.koryu25.lifeworld.yaml;

import com.github.koryu25.lifeworld.LWMain;

public final class MainConfig extends CustomConfig {

    public MainConfig() {
        super(LWMain.getInstance(), "config.yml");
    }

    // MySQL
    public String getHost() {
        return getConfig().getString("mysql.host", "host");
    }
    public int getPort() {
        return getConfig().getInt("mysql.port", 3306);
    }
    public String getDatabase() {
        return getConfig().getString("mysql.database", "life_world");
    }
    public String getUsername() {
        return getConfig().getString("mysql.username", "root");
    }
    public String getPassword() {
        return getConfig().getString("mysql.password", null);
    }

    // Game Play
    public String getMainWorld() {
        return getConfig().getString("world.main", "world");
    }
    public int getInitialAge() {
        return getConfig().getInt("initial.age", 13);
    }
}
