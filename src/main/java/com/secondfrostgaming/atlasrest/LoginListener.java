package com.secondfrostgaming.atlasrest;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.json.JSONObject;

import static spark.Spark.post;

public class LoginListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        //Create post to Discord Webhook that a player has joined
        //Use test webhooks URL: https://webhook.site/709b58d8-9ecd-46cd-adc2-0d22b663142b

        String msg = event.getPlayer().getName().concat(" has logged into the server");
        post("https://webhook.site/709b58d8-9ecd-46cd-adc2-0d22b663142b", (request, response) -> {
            response.type("application/json");
            return new JSONObject()
                            .put("logon_msg", msg).toString();
        });
    }
}
