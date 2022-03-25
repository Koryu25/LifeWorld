package com.github.koryu25.lifeworld.data.mysql;

import com.github.koryu25.lifeworld.LifeWorldMain;
import com.github.koryu25.lifeworld.yaml.MainConfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManager {

    private static MySQLManager instance;

    private Connection connection;
    private final String host;
    private final int port;
    private final String database;
    private final String username;
    private final String password;

    private MySQLManager(JavaPlugin main, String host, int port, String database, String username, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
        // テスト
        if (!connectionTest()) {
            main.getLogger().severe("§cデータベースへの接続テストに失敗しました。サーバーを停止します。");
            Bukkit.shutdown();
        }
    }
    public Boolean connectionTest() {
        try {
            openConnection();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    private void openConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) return;
        synchronized (this) {
            if (connection != null && !connection.isClosed()) return;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+ host +":"+ port +"/"+ database, username, password);
        }
    }

    public static void construct() {
        instance = new MySQLManager(
                LifeWorldMain.getInstance(),
                MainConfig.getHost(),
                MainConfig.getPort(),
                MainConfig.getDatabase(),
                MainConfig.getUsername(),
                MainConfig.getPassword()
        );
    }

    public static Connection getConnection() {
        return instance.connection;
    }
}
