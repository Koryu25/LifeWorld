package com.github.koryu25.lifeworld.mysql;

import com.github.koryu25.lifeworld.LifeWorldMain;
import org.bukkit.Bukkit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Select {

    /*
    public static Life life(String uuid) {
        try {
            String s = "SELECT * FROM life WHERE uuid = ?";
            PreparedStatement ps = LifeWorldMain.getMySQLManager().getConnection().prepareStatement(s);
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Life(Bukkit.getPlayer(UUID.fromString(uuid)));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
     */
}
