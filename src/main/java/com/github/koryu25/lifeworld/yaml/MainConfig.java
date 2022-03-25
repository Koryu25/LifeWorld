package com.github.koryu25.lifeworld.yaml;

import com.github.koryu25.lifeworld.LifeWorldMain;
import org.bukkit.plugin.java.JavaPlugin;

public final class MainConfig extends CustomConfig {

    private static MainConfig instance;

    private MainConfig(JavaPlugin main) {
        super(main, "config.yml");
    }

    // MySQL
    public static String getHost() {
        return instance.getConfig().getString("mysql.host", "host");
    }
    public static int getPort() {
        return instance.getConfig().getInt("mysql.port", 3306);
    }
    public static String getDatabase() {
        return instance.getConfig().getString("mysql.database", "life_world");
    }
    public static String getUsername() {
        return instance.getConfig().getString("mysql.username", "root");
    }
    public static String getPassword() {
        return instance.getConfig().getString("mysql.password", null);
    }

    // Game Play
    public static String getMainWorld() {
        return instance.getConfig().getString("world.main", "world");
    }
    public static int getInitialAge() {
        return instance.getConfig().getInt("initial.age", 13);
    }

    public static void construct() {
        instance = new MainConfig(LifeWorldMain.getInstance());
    }
}
