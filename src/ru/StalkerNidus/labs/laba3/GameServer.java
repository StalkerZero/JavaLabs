package ru.StalkerNidus.labs.laba3;

import java.util.Scanner;

public class GameServer {
    private GameConfig config = new GameConfig();
    private World serverWorld = new World();
    private int serverTicks = 0;
    private static GameServer instance;

    public void updateServer(){
        serverWorld.updateWorld();
        serverTicks++;
    }

    public GameServer(GameConfig config, World serverWorld, int serverTicks) {
        this.config = config;
        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;
    }

    public GameServer(){
        instance = this;
        Scanner scan = new Scanner(System.in);
        System.out.print("How much Rats? ");
        int rat=scan.nextInt();
        System.out.print("How much Rabbits? ");
        int rabb=scan.nextInt();
        System.out.print("How much Players? ");
        int play=scan.nextInt();
        for (int i = 0; i < rat+rabb+play; i++) {
            if (i<rat) serverWorld.getEntities().add(new Entity("Rat"));
            else if (i<rat+rabb) serverWorld.getEntities().add(new Entity("Rabbit"));
                 else serverWorld.getEntities().add(new EntityPlayer());
        }
    }

    public static void main(String[] args) {
        new GameServer();
        System.out.println(instance.toString());
        for (int i = 0; i < 50; i++) {
            GameServer.getInstance().updateServer();
            try {
                Thread.sleep(GameServer.getInstance().getConfig().getUpdatePeriod());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(instance.toString());
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
