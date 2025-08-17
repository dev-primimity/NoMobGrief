package me.primimity.noMobGrief;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);

        System.out.println("\n" +
                getDescription().getName() + " v" + getDescription().getVersion() + "\n" +
                "Created by " + getDescription().getAuthors() + "\n" +
                "Need a custom plugin? Discord me @primimity\n");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // NoMobGrief
    @EventHandler
    public void doCreeperExplosions(EntityExplodeEvent e) {
        if (e.getEntityType() == EntityType.CREEPER && !getConfig().getBoolean("doCreeperExplosions", true)) {
            e.blockList().clear();
        }
    }
    @EventHandler
    public void doEndermanPickup(EntityChangeBlockEvent e) {
        if (e.getEntityType() == EntityType.ENDERMAN && !getConfig().getBoolean("doEndermanPickup", true)) {
            e.setCancelled(true);
        }
    }
}
