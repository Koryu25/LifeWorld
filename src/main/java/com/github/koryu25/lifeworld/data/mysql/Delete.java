package com.github.koryu25.lifeworld.data.mysql;

import com.github.koryu25.lifeworld.block.LWBlock;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

    public static void lwBlock(LWBlock lwBlock) {
        try {
            String s = "DELETE FROM block WHERE x = ? AND y = ? AND z = ?";
            PreparedStatement ps = MySQLManager.getConnection().prepareStatement(s);
            ps.setInt(1, lwBlock.x);
            ps.setInt(2, lwBlock.y);
            ps.setInt(3, lwBlock.z);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
