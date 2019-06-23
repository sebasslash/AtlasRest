package com.secondfrostgaming.atlasrest.Server;


import com.secondfrostgaming.atlasrest.Main;
import com.secondfrostgaming.atlasrest.Path;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONObject;

import static spark.Spark.*;

public class ServerRoutes {

    //Might want to "cache" this for several routes
    private ServerInfo server;

    public ServerInfo getServerInfo() { return new ServerInfo(); }

    public ServerRoutes() {

        get(Path.Web.SERVER_INFO, (request, response) -> {
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

//                JavaPlugin.getPlugin(Main.class).getLogger().info(json);
                return json;
            } catch (Exception e) {
                JavaPlugin.getPlugin(Main.class).getLogger().info(e.toString());
            }
            return "{}";
        });

        get(Path.Web.SERVER_SYSTEM, (request, response) -> {
            response.type("application/json");
          return "{}";
        });

        get(Path.Web.SERVER_SPIGOT, (request, response) -> {
            response.type("application/json");
          return "{}";
        });

        get(Path.Web.SERVER_STATS, (request,response) -> {
            response.type("application/json");

            return "{}";
        });

        // Reloads the entire server
        post(Path.Web.SERVER_RELOAD, (request,response) -> {
            response.type("application/json");
            try {
                JavaPlugin.getPlugin(Main.class).getServer().reload();
                return new JSONObject().put("state", "Server was reloaded successfully").toString();
            } catch (Exception e) {
                return new JSONObject().put("state", "Server could not be reloaded").put("error", e.toString()).toString();
            }
        });

        notFound((request, response) -> {
           return "404: Status Not Found";
        });

    }

}
