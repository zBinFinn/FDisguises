package io.github.zbinfinn;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import io.github.zbinfinn.commands.DisguiseCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FinnsDisguisesPlugin extends JavaPlugin {
    private static FinnsDisguisesPlugin instance;

    @Override
    public void onLoad() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().load();
        PacketEvents.getAPI().getEventManager().registerListener(new PacketHandler(), PacketListenerPriority.NORMAL);
        instance = this;
    }

    @Override
    public void onEnable() {
        PacketEvents.getAPI().init();
        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {
        PacketEvents.getAPI().terminate();
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
    }

    private void registerCommands() {
        Bukkit.getPluginCommand("disguise").setExecutor(new DisguiseCommand());
    }
}
