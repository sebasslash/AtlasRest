package com.secondfrostgaming.atlasrest;


import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONObject;

import static spark.Spark.get;
import static spark.Spark.notFound;
public class ServerRoutes {

    //Might want to "cache" this for several routes
    private ServerInfo server;
    public ServerInfo getServerInfo() { return new ServerInfo(); }

    public ServerRoutes() {

        get("/api/server/info", (request, response) -> {
            server = getServerInfo();
            JavaPlugin.getPlugin(Main.class).getLogger().info("HTTP [GET] : /api/server/info");
            response.type("application/json");
            try{
                String json = new JSONObject()
                            .put("name", server.getName())
                            .put("ip", server.getIp())
                            .put("port", server.getPort())
                            .put("version", server.getVersion())
                            .put("online_players", server.getPlayers().toArray())
                            .put("player_count", server.getPlayerCount())
                            .put("max_player_count", server.getMaxPlayerCount())
                            .put("system", server.getSystemInfo().toString()).toString();

                JavaPlugin.getPlugin(Main.class).getLogger().info(json);
                return json;
            } catch (Exception e) {
                JavaPlugin.getPlugin(Main.class).getLogger().info(e.toString());
            }
            return "{}";
        });

        get("/api/server/system", (request, response) -> {
          return "{}";
        });

        get("/api/server/spigot", (request, response) -> {
          return "{}";
        });

        get("/api/server/stats", (request,response) -> {
            return "{}";
        });
        get("/api/server/reload", (request,response) -> {
          return "{}";
        });

        notFound((request, response) -> {
           return "404: Status Not Found";
        });

    }

}
