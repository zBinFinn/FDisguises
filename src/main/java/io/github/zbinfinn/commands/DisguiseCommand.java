package io.github.zbinfinn.commands;

import io.github.zbinfinn.FDisguise;
import io.github.zbinfinn.FDisguisesAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DisguiseCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        Entity target = player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
        FDisguisesAPI.disguise(target, new FDisguise(EntityType.CAMEL));

        return false;
    }
}
