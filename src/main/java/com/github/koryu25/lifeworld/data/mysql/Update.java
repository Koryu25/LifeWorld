package com.github.koryu25.lifeworld.data.mysql;

import com.github.koryu25.lifeworld.block.LWBlock;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

    public static void lwBlock(LWBlock lwBlock) {
        try {
            String s = "UPDATE block SET kind = ?";
            PreparedStatement ps = MySQLManager.getConnection().prepareStatement(s);
            ps.setString(1, lwBlock.kind);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
