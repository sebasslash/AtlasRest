package com.secondfrostgaming.atlasrest;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONObject;
import oshi.SystemInfo;

import java.util.ArrayList;
import java.util.Collection;


public class ServerInfo {
    private String name;
    private boolean isOnline;
    private int playerCount;
    private int maxPlayerCount;
    private Collection<? extends Player> players;
    private String ip;
    private int port;
    private String version;
    private double ping;

    //System Details for Expanded View
    public ServerInfo() {

        this.name = JavaPlugin.getPlugin(Main.class).getServer().getServerName();
        this.isOnline = JavaPlugin.getPlugin(Main.class).getServer().getOnlineMode();

        this.playerCount = JavaPlugin.getPlugin(Main.class).getServer().getOnlinePlayers().size();
        this.maxPlayerCount = JavaPlugin.getPlugin(Main.class).getServer().getMaxPlayers();
        this.players = JavaPlugin.getPlugin(Main.class).getServer().getOnlinePlayers();

        this.ip = JavaPlugin.getPlugin(Main.class).getServer().getIp();
        this.port = JavaPlugin.getPlugin(Main.class).getServer().getPort();
        this.version = JavaPlugin.getPlugin(Main.class).getServer().getVersion();
    }



    public JSONObject getSystemInfo() {
        SystemInfo info = new SystemInfo();
         return new JSONObject()
                            .put("CPU", new JSONObject()
                                        .put("MODEL", "blah").toString())
                            .put("OS", new JSONObject()
                                        .put("OS_FAMILY", info.getOperatingSystem().getFamily())
                                        .put("OS_MANUFACTURER", info.getOperatingSystem().getManufacturer())
                                        .put("OS_VERSION", info.getOperatingSystem().getVersion()).toString())
                            .put("MEMORY", new JSONObject()
                                        .put("AVAILABLE_MEMORY", info.getHardware().getMemory().getAvailable())
                                        .put("TOTAL_MEMORY", info.getHardware().getMemory().getTotal()));
    }
    public String getName() { return name; }

    public boolean isOnline() { return isOnline; }

    public int getPlayerCount() { return playerCount; }

    public int getMaxPlayerCount() { return maxPlayerCount; }

    public ArrayList<String> getPlayers() {
        ArrayList<String> playerList = new ArrayList<>();
        this.players.forEach((p) -> {
           playerList.add(p.getDisplayName());
        });

        return playerList;
    }

    public String getIp() { return ip; }

    public int getPort() { return port; }

    public String getVersion() { return version; }
}
