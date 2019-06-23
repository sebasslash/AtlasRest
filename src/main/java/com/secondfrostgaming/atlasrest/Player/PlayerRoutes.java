package com.secondfrostgaming.atlasrest.Player;

import com.secondfrostgaming.atlasrest.Main;
import com.secondfrostgaming.atlasrest.Path;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONObject;

import static spark.Spark.post;

public class PlayerRoutes {
    public PlayerRoutes() {
        JavaPlugin plugin = JavaPlugin.getPlugin(Main.class);
        post(Path.Web.PLAYER_MSG, (request, response) -> {
            String playerName = request.params("player");
            JSONObject serverResponse = new JSONObject();
            try {
                Player player = plugin.getServer().getPlayer(playerName);
                player.sendMessage(request.queryParams("message"));
                return serverResponse.put("success", "Message sent successfully");
            } catch(Exception e) {
                return serverResponse.put("error", "Message could not be sent: " + e.toString());
            }
        });
        post(Path.Web.PLAYER_MSG_ALL, (request,response) -> {
            JSONObject serverResponse = new JSONObject();
            try {
                plugin.getServer().broadcastMessage(request.queryParams("message"));
                return serverResponse.put("success", "Message broadcasted successfully");
            } catch(Exception e) {
               return serverResponse.put("error", "Message could not be broadcasted: Error: " + e.toString());
            }
        });
    }
}
