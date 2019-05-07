package com.secondfrostgaming.atlasrest;


import org.bukkit.entity.Player;
import org.json.JSONObject;

import java.util.Collection;
import java.util.Collections;

import static spark.Spark.*;
public class ServerRoutes {

    //Might want to "cache" this for several routes
    private ServerInfo server;
    public ServerInfo getServerInfo() { return new ServerInfo(); }

    public ServerRoutes() {

        get("/api/server/info", (request, response) -> {
            server = getServerInfo();
            response.type("application/json");
            String json = new JSONObject()
                            .put("name", server.getName())
                            .put("ip", server.getIp())
                            .put("port", server.getPort())
                            .put("version", server.getVersion())
                            .put("online_players", server.getPlayers().toArray())
                            .put("player_count", server.getPlayerCount())
                            .put("max_player_count", server.getMaxPlayerCount()).toString();
            return json;
        });

        notFound((request, response) -> {
           return "404: Status Not Found";
        });

    }

}
