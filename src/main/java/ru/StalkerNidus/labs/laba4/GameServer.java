package ru.StalkerNidus.labs.laba4;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import static ru.StalkerNidus.labs.laba4.DatabaseUtils.*;
import static ru.StalkerNidus.labs.laba4.FileUtils.*;

public class GameServer {
    private GameConfig config;
    private World serverWorld;
    private int serverTicks = 0;
    private static GameServer instance;

    public void updateServer() throws SQLException {
        serverWorld.updateWorld();
        serverTicks++;
        if (serverTicks%5==0) {
            try {
                saveWorld(new File("./save/world.txt"), serverWorld);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadConf() throws IOException {
        config = loadConfig(new File("./save/config.txt"));
        if(config!=null) return;
        config = new GameConfig();
        saveConfig(new File("./save/config.txt"), config);
    }

    private void loadworld() throws IOException, SQLException {
        serverWorld = loadWorld(new File("./save/world.txt"));
        if(serverWorld!=null) return;
        serverWorld = new World();
        saveWorld(new File("./save/world.txt"), serverWorld);
    }

    public GameServer(GameConfig config, World serverWorld) throws SQLException {
        createTableEntity();
        createTablePlayer();
        createTableLogs();
        instance = this;
        this.config = config;
        this.serverWorld = serverWorld;
    }

    public GameServer() throws SQLException {
        createTableEntity();
        createTablePlayer();
        createTableLogs();
        instance = this;
        config = new GameConfig();
        serverWorld = new World();
    }

    public static void main(String[] args) {
        try {
            new GameServer();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return;
        }
//        try {
//            new GameServer(FileUtils.loadConfig(new File("./save/config.txt")), FileUtils.loadWorld(new File("./save/world.txt")));
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//        }
        System.out.println("Success");
        //System.out.println(instance.toString());
        for (int i = 0; i < 50; i++) {
            try {
                GameServer.getInstance().updateServer();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                Thread.sleep(GameServer.getInstance().getConfig().getUpdatePeriod());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "GameServer{" +
                "config=" + config +
                ", serverWorld=" + serverWorld +
                ", serverTicks=" + serverTicks +
                '}';
    }

    public GameConfig getConfig() {
        return config;
    }

    public void setConfig(GameConfig config) {
        this.config = config;
    }

    public void setServerWorld(World serverWorld) {
        this.serverWorld = serverWorld;
    }

    public void setServerTicks(int serverTicks) {
        this.serverTicks = serverTicks;
    }

    public World getServerWorld() {
        return serverWorld;
    }

    public int getServerTicks() {
        return serverTicks;
    }

    public static GameServer getInstance() {
        return instance;
    }
}
