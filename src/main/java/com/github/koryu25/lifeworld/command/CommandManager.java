package com.github.koryu25.lifeworld.command;

import com.github.koryu25.lifeworld.LWMain;
import com.github.koryu25.lifeworld.item.LWItemManager;
import com.github.koryu25.lifeworld.item.items.TestOreItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            PlayerInventory inv = player.getInventory();

            LWItemManager lim = LWMain.getInstance().getLwItemManager();
            ItemStack ore = lim.create(new TestOreItem());

            inv.addItem(ore);
        }
        return false;
    }
}
