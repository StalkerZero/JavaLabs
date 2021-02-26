package ru.StalkerNidus.labs.laba1;

import java.util.Arrays;
import java.util.Scanner;

public class GameServer {
    private String ip;
    private int difficulty;
    private Entity[] entities;
    private static GameServer instance;
    private Scanner scan = new Scanner(System.in);

    public void updateServer(){
        for (int i = 0; i < entities.length; i++) {
            entities[i].update();
        }
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
        this.entities = new Entity[rat+rabb+play];
        for (int i = 0; i < rat+rabb+play; i++) {
            if (i<rat)entities[i]= new Entity("Rat");
            else if (i<rat+rabb)entities[i]= new Entity("Rabbit");
                 else entities[i]= new EntityPlayer();
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
                ", entities=" + Arrays.toString(entities) +
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

    public Entity[] getEntities() {
        return entities;
    }

    public void setEntities(Entity[] entities) {
        this.entities = entities;
    }

    public static GameServer getInstance() {
        return instance;
    }
}
