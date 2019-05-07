package com.secondfrostgaming.atlasrest;


import static spark.Spark.*;

public class AtlasServer implements Runnable{
    @Override
    public void run() {
        port(8088);
        initExceptionHandler((e) -> System.out.println("Uh-oh \n" + e));
        ServerRoutes serverRoutes = new ServerRoutes();
    }
}
