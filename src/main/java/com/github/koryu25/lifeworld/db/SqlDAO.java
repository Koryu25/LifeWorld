package com.github.koryu25.lifeworld.db;

import com.github.koryu25.lifeworld.player.LWPlayer;
import com.github.koryu25.lifeworld.player.jobs.Job;
import com.github.koryu25.lifeworld.player.jobs.skill.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SqlDAO {

    private Connection conn;

    public SqlDAO(SqlConnector connector) {
        conn = connector.getConnection();
    }

    public List<Job> initJobs() {
        String sql = "select job.id, job.player_name, job.job_level, job.job_exp, job_category.job_name, job_category.skill_name from job inner join job_category on job.job_id = job_category.job_id";
        return null;
    }

    public List<LWPlayer> initLWPlayers() {
        String sql = "select player.player_name,player.player_uuid,player.player_level,player.player_exp, player.player_hp, player.player_strength, grade.grade_name, country.country_name  from ( player inner join grade on player.gradeID = grade.grade_id) inner join country on grade.country_id = country.country_id";

        List<Skill> skills = new ArrayList<>();
        List<Job> jobs = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String player_name = rs.getString("player_name");
                UUID player_uuid = UUID.fromString(rs.getString("player_uuid"));
                int player_level = rs.getInt("player_level");
                double player_exp = rs.getDouble("player_exp");
                int player_hp = rs.getInt("player_hp");
                int player_strength = rs.getInt("player_strength");

                LWPlayer lwPlayer = new LWPlayer(player_name, player_uuid, player_level, player_exp, player_hp, player_strength);

                int job_level = rs.getInt("job_level");
                double job_exp = rs.getDouble("job_exp");
                String job_name = rs.getString("job_name");
                String skill_name = rs.getString("skill_name");

                Job job = new Job(job_name, job_level, job_exp, skill_name);
                lwPlayer.addJob(job);


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
