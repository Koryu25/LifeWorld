package com.github.koryu25.lifeworld.data;

import com.github.koryu25.lifeworld.LWMain;
import com.github.koryu25.lifeworld.block.LWBlock;
import org.bukkit.Bukkit;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SqlDAO {

    private Connection connection;
    private final String host;
    private final int port;
    private final String database;
    private final String username;
    private final String password;

    public SqlDAO() {
        this(
                LWMain.getInstance(),
                LWMain.getInstance().getMainConfig().getHost(),
                LWMain.getInstance().getMainConfig().getPort(),
                LWMain.getInstance().getMainConfig().getDatabase(),
                LWMain.getInstance().getMainConfig().getUsername(),
                LWMain.getInstance().getMainConfig().getPassword()
        );
    }
    public SqlDAO(LWMain main, String host, int port, String database, String username, String password) {
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

    private boolean connectionTest() {
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
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
            //Message
            Bukkit.getLogger().info("§3Setting up MySQL");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    //ここからSQL処理
    public boolean deleteBlockData(LWBlock lwBlock) {
        try {
            String s = "DELETE FROM block WHERE x = ? AND y = ? AND z = ?";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.setInt(1, lwBlock.x);
            ps.setInt(2, lwBlock.y);
            ps.setInt(3, lwBlock.z);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isExistBlockData(LWBlock lwBlock) {
        try {
            String s = "SELECT * FROM block WHERE x = ? AND y = ? AND z = ?";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.setInt(1, lwBlock.x);
            ps.setInt(2, lwBlock.y);
            ps.setInt(3, lwBlock.z);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertBlockData(LWBlock lwBlock) {
        try {
            String s = "INSERT INTO block (x, y, z, kind) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.setInt(1, lwBlock.x);
            ps.setInt(2, lwBlock.y);
            ps.setInt(3, lwBlock.z);
            ps.setString(4, lwBlock.kind);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Set<LWBlock> getAllBlockData() {
        try {
            String s = "SELECT * FROM block";
            PreparedStatement ps = connection.prepareStatement(s);
            ResultSet rs = ps.executeQuery();
            Set<LWBlock> set = new HashSet<>();
            while (rs.next()) {
                LWBlock lwBlock = LWBlock.of(
                        rs.getString("kind"),
                        rs.getInt("x"),
                        rs.getInt("y"),
                        rs.getInt("z")
                );
                set.add(lwBlock);
            }
            return set;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }

    public boolean updateBlockData(LWBlock lwBlock) {
        try {
            String s = "UPDATE block SET kind = ?";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.setString(1, lwBlock.kind);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}