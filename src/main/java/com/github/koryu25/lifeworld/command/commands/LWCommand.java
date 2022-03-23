package com.github.koryu25.lifeworld.command.commands;

import com.github.koryu25.lifeworld.command.CommandProcessor;
import com.github.koryu25.lifeworld.item.LWItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LWCommand extends CommandProcessor {

    public LWCommand() {
        super("lw");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) return true;
        if (args.length != 1) return true;
        String arg0 = args[0];
        if (arg0.equalsIgnoreCase("iorb")) {
            player.getInventory().addItem(LWItemManager.IRON_ORE_RESOURCE_BLOCK.toItemStack());
            return true;
        } else if (arg0.equalsIgnoreCase("rd")) {
            player.getInventory().addItem(LWItemManager.RESOURCE_DISASSEMBLER.toItemStack());
            return true;
        }
        return true;
    }
}
