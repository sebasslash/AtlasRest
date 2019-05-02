package com.secondfrostgaming.atlasrest;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

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

    public String getName() { return name; }

    public boolean isOnline() { return isOnline; }

    public int getPlayerCount() { return playerCount; }

    public int getMaxPlayerCount() { return maxPlayerCount; }

    public Collection<? extends Player> getPlayers() { return players; }

    public String getIp() { return ip; }

    public int getPort() { return port; }

    public String getVersion() { return version; }
}
