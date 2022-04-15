package com.github.koryu25.lifeworld.player.jobs.skill;

import lombok.Data;

@Data
public class Skill {

    private String skillName;

    public Skill(String skillName) {
        this.skillName = skillName;
    }
}
