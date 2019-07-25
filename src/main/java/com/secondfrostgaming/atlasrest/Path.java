package com.secondfrostgaming.atlasrest;

public class Path {
    public class Web {
        private final static String API_SERVER = "api/server";
        public final static String SERVER_INFO = API_SERVER + "/info";
        public final static String SERVER_SYSTEM = API_SERVER + "/system";
        public final static String SERVER_SPIGOT = API_SERVER + "/spigot";
        public final static String SERVER_STATS = API_SERVER + "/stats";
        public final static String SERVER_RELOAD = API_SERVER + "/reload";

        private final static String API_PLAYER = "api/player";
        public final static String PLAYER_MSG = API_PLAYER + "/msg/:name";
        public final static String PLAYER_MSG_ALL = API_PLAYER + "/broadcast";
    }
}
