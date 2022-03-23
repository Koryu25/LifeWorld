package com.github.koryu25.lifeworld.command;

import org.bukkit.command.CommandExecutor;

public abstract class CommandProcessor implements CommandExecutor {

    public final String command;

    protected CommandProcessor(String command) {
        this.command = command;
    }
}
