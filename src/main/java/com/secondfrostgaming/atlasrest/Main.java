package com.secondfrostgaming.atlasrest;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    Thread server;
    private int tps;
    @Override
    public void onEnable() {
        getLogger().info("Atlas REST plugin enabled");
        server = new Thread(new AtlasServer());
        server.run();
    }

    @Override
    public void onDisable() {
        getLogger().info("Atlas REST plugin disabled");
        server.interrupt();
    }

}
