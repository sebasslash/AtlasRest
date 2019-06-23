package com.secondfrostgaming.atlasrest;


import com.secondfrostgaming.atlasrest.Player.PlayerRoutes;
import com.secondfrostgaming.atlasrest.Server.ServerRoutes;

import static spark.Spark.*;

public class AtlasServer implements Runnable{
    @Override
    public void run() {
        port(8088);
        initExceptionHandler((e) -> System.out.println("Uh-oh \n" + e));
        ServerRoutes serverRoutes = new ServerRoutes();
        PlayerRoutes playerRoutes = new PlayerRoutes();
    }
}
