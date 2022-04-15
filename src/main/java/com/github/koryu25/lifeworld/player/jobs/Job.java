package com.github.koryu25.lifeworld.player.jobs;

import com.github.koryu25.lifeworld.player.jobs.skill.Skill;
import lombok.Data;

import java.util.List;

@Data
public class Job {

    private String name;
    private int level;
    private double exp;
    private String skill_name;

    public Job(String name, int level, double exp, String skill_name) {
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.skill_name = skill_name;
    }

}
