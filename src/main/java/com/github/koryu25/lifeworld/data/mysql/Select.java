package com.github.koryu25.lifeworld.data.mysql;

import com.github.koryu25.lifeworld.block.LWBlock;
import com.github.koryu25.lifeworld.data.LWBlockDataSet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Select {

    /*
    public static Life life(String uuid) {
        try {
            String s = "SELECT * FROM life WHERE uuid = ?";
            PreparedStatement ps = MySQLManager.getConnection().prepareStatement(s);
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

    public static Set<LWBlock> allLWBlock() {
        try {
            String s = "SELECT * FROM block";
            PreparedStatement ps = MySQLManager.getConnection().prepareStatement(s);
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
}
