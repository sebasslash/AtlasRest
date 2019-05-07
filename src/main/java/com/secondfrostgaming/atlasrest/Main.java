package com.secondfrostgaming.atlasrest;

import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONObject;
import static spark.Spark.*;

public class Main extends JavaPlugin {

    Thread server;
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
