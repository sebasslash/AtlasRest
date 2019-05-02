package com.secondfrostgaming.atlasrest;

import org.bukkit.plugin.java.JavaPlugin;

import static spark.Spark.initExceptionHandler;
import static spark.Spark.stop;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Atlas REST plugin enabled");
        initExceptionHandler((e) -> System.out.println("Uh-oh"));
    }

    @Override
    public void onDisable() {
        getLogger().info("Atlas REST plugin disabled");
        stop();
    }
}
