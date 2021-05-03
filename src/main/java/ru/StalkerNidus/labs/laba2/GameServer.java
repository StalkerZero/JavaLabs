package ru.StalkerNidus.labs.laba2;

import java.util.Scanner;

public class GameServer {
    private String ip;
    private int difficulty;
    private World serverWorld = new World();
    private int serverTicks = 0;
    private static GameServer instance;
    private Scanner scan = new Scanner(System.in);

    public void updateServer(){
        serverWorld.updateWorld();
        serverTicks++;
    }

    public GameServer(){
        instance = this;
        this.ip = "192.168.254.61";
        System.out.print("Enter difficulty(1-3):");
        this.difficulty = scan.nextInt();
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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(instance.toString());
    }

    @Override
    public String toString() {
        return "GameServer{" +
                "ip='" + ip + '\'' +
                ", difficulty=" + difficulty +
                ", serverWorld=" + serverWorld +
                ", serverTicks=" + serverTicks +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
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
