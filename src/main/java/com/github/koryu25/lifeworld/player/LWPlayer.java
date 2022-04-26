package com.github.koryu25.lifeworld.player;

import com.github.koryu25.lifeworld.player.jobs.Job;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class LWPlayer {

    private String name;
    private UUID uuid;
    private int level;
    private double exp;
    private int hp;
    private int strength;

    private String grade;
    private String countryName;

    private final List<Job> jobs = new ArrayList<>();

    public LWPlayer(String name, UUID uuid, int level, double exp, int hp, int strength) {
        this.name = name;
        this.uuid = uuid;
        this.level = level;
        this.exp = exp;
        this.hp = hp;
        this.strength = strength;
    }

    public void addJob(Job job) {
        this.jobs.add(job);
    }



}
