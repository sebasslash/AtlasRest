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


    SystemInfo info;
    private String osFamily;
    private String osManufacturer;

    JavaPlugin pluginClass;

    //System Details for Expanded View

    public ServerInfo() {

        this.info = new SystemInfo();
        this.osFamily = this.info.getOperatingSystem().getFamily();
        this.osManufacturer = this.info.getOperatingSystem().getManufacturer();

        this.pluginClass = JavaPlugin.getPlugin(Main.class);

        this.name = this.pluginClass.getServer().getServerName();
        this.isOnline = this.pluginClass.getServer().getOnlineMode();
        this.playerCount = this.pluginClass.getServer().getOnlinePlayers().size();
        this.maxPlayerCount = this.pluginClass.getServer().getMaxPlayers();
        this.players = this.pluginClass.getServer().getOnlinePlayers();
        this.ip = this.pluginClass.getServer().getIp();
        this.port = this.pluginClass.getServer().getPort();
        this.version = this.pluginClass.getServer().getVersion();
    }



    public JSONObject getSystemInfo() {
         return new JSONObject()
                            .put("CPU", new JSONObject()
                                        .put("MODEL", "blah").toString())
                            .put("OS", new JSONObject()
                                        .put("OS_FAMILY", this.osFamily)
                                        .put("OS_MANUFACTURER", this.osManufacturer)
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
