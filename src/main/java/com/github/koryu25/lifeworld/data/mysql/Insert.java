package com.github.koryu25.lifeworld.data.mysql;

import com.github.koryu25.lifeworld.block.LWBlock;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

    public static void lwBlock(LWBlock lwBlock) {
        try {
            String s = "INSERT INTO block (x, y, z, kind) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = MySQLManager.getConnection().prepareStatement(s);
            ps.setInt(1, lwBlock.x);
            ps.setInt(2, lwBlock.y);
            ps.setInt(3, lwBlock.z);
            ps.setString(4, lwBlock.kind);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
