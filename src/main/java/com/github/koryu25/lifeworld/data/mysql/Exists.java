package com.github.koryu25.lifeworld.data.mysql;

import com.github.koryu25.lifeworld.block.LWBlock;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exists {

    public static boolean lwBlock(LWBlock lwBlock) {
        try {
            String s = "SELECT * FROM block WHERE x = ? AND y = ? AND z = ?";
            PreparedStatement ps = MySQLManager.getConnection().prepareStatement(s);
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
}
