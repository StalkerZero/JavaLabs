package ru.StalkerNidus.labs.laba3;

import java.io.File;
import java.io.IOException;

public class GameServer {
    private GameConfig config;
    private World serverWorld;
    private int serverTicks = 0;
    private static GameServer instance;

    public void updateServer(){
        serverWorld.updateWorld();
        serverTicks++;
        if (serverTicks%5==0) {
            try {
                FileUtils.saveWorld(new File("./save/world.txt"), serverWorld);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadConfig() throws IOException {
        config = FileUtils.loadConfig(new File("./save/config.txt"));
        if(config!=null) return;
        config = new GameConfig();
        FileUtils.saveConfig(new File("./save/config.txt"), config);
    }

    private void loadWorld() throws IOException {
        serverWorld = FileUtils.loadWorld(new File("./save/world.txt"));
        if(serverWorld!=null) return;
        serverWorld = new World();
        FileUtils.saveWorld(new File("./save/world.txt"), serverWorld);
    }

    public GameServer(GameConfig config, World serverWorld) {
        instance = this;
        this.config = config;
        this.serverWorld = serverWorld;
    }

    public GameServer(){
        instance = this;
        config = new GameConfig();
        serverWorld = new World();
    }

    public static void main(String[] args) {
//        new GameServer();
        try {
            new GameServer(FileUtils.loadConfig(new File("./save/config.txt")), FileUtils.loadWorld(new File("./save/world.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Success");
        //System.out.println(instance.toString());
        for (int i = 0; i < 50; i++) {
            GameServer.getInstance().updateServer();
            try {
                Thread.sleep(GameServer.getInstance().getConfig().getUpdatePeriod());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(instance.toString());
//        double ms = System.currentTimeMillis();
//        try {
//            FileUtils.saveWorld(new File("./save/world.txt"), GameServer.getInstance().getServerWorld());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis()-ms);
//        ms = System.currentTimeMillis();
//        try {
//            World world1 = FileUtils.loadWorld(new File("./save/world.txt"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis()-ms);
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
