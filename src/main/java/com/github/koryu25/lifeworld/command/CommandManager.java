package com.github.koryu25.lifeworld.command;

import com.github.koryu25.lifeworld.command.commands.LWCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandManager {

    private final JavaPlugin main;

    public CommandManager(JavaPlugin main) {
        this.main = main;
        setExecutor(new LWCommand());
    }

    private void setExecutor(CommandProcessor processor) {
        main.getCommand(processor.command).setExecutor(processor);
    }
}
