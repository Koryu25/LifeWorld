package com.github.koryu25.lifeworld.player;

import com.github.koryu25.lifeworld.LWMain;
import com.github.koryu25.lifeworld.yaml.MainConfig;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

public class LWPlayer {

    @Getter
    private final Player player;
    // 年齢
    @Getter @Setter
    private int age;
    // 体力(HP)
    @Getter @Setter
    private int hitPoint;
    // 筋力Strength
    @Getter @Setter
    private int strength;
    // 丈夫さVitality
    @Getter @Setter
    private int vitality;
    // 俊敏性Agility
    // 知力Intelligence
    @Getter @Setter
    private int intelligence;
    // 精神力Mind
    // 器用さDexterity
    // 運Lucky
    @Getter @Setter
    private int lucky;

    public LWPlayer(Player player) {
        this(player, LWMain.getInstance().getMainConfig().getInitialAge());
    }
    public LWPlayer(Player player, int age) {
        this.player = player;
        this.age = age;
    }
}
