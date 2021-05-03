package ru.StalkerNidus.labs.laba3;
import java.io.*;

public class FileUtils {

    public static void saveConfig(File path, GameConfig config) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path)))
        {
            StringBuilder sb = new StringBuilder();
            sb.append("ip=").append(config.getIp())
                    .append("\nport=").append(config.getPort())
                    .append("\ndifficulty=").append(config.getDifficulty())
                    .append("\nupdatePeriod=").append(config.getUpdatePeriod())
                    .append("\nsavePeriod=").append(config.getSavePeriod());
            bw.write(sb.toString());
        }
    }
    public static GameConfig loadConfig(File path) throws IOException {
        if (!path.exists()) return null;
        try(BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            StringBuilder sb = new StringBuilder();
            String s;
            String[] arr;
            while((s = br.readLine()) != null) {
                arr=s.split("=");
                sb.append(arr[1]).append(";");
            }
            arr = sb.toString().split(";");
            return new GameConfig(arr[0],
                    Integer.parseInt(arr[1]),
                    Integer.parseInt(arr[2]),
                    Long.parseLong(arr[3]),
                    Integer.parseInt(arr[4])
            );
        }
    }

    public static void saveWorld(File path, World world) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path)))
        {
            StringBuilder sb = new StringBuilder();
            sb.append(world.getId()).append(";").append(world.getWorldName()).append("\n");
            for(Entity e : world.getEntities()) {
                sb.append(e.getId()).append(";")
                        .append(e.isLife()).append(";")
                        .append(e.getTitle()).append(";")
                        .append(e.getPosX()).append(";")
                        .append(e.getPosY()).append(";")
                        .append(e.isAggressive()).append(";")
                        .append(e.getMaxHealth()).append(";")
                        .append(e.getHealth()).append(";")
                        .append(e.getAttackDamage());
                if (e instanceof  EntityPlayer) sb.append(";").append(((EntityPlayer) e).getNickname());
                sb.append("\n");
            }
            sb.append(Entity.getIdCounter());
            bw.write(sb.toString());
        }
    }
    public static World loadWorld(File path) throws IOException{
        if (!path.exists()) return null;
        try(BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            String s;
            String[] arr = br.readLine().split(";");
            World world = new World(Integer.parseInt(arr[0]), arr[1]);

            while((s = br.readLine()) != null) {
                arr=s.split(";");
                if(arr.length==1){
                    Entity.setIdCounter(Long.parseLong(arr[0]));
                    break;
                }
                if(arr[2].equals("player")) world.getEntities().add(new EntityPlayer(
                        Long.parseLong(arr[0]),
                        Boolean.parseBoolean(arr[1]),
                        arr[2],
                        Double.parseDouble(arr[3]),
                        Double.parseDouble(arr[4]),
                        Boolean.parseBoolean(arr[5]),
                        Integer.parseInt(arr[6]),
                        Double.parseDouble(arr[7]),
                        Integer.parseInt(arr[8]),
                        arr[9],
                        world));
                else world.getEntities().add(new Entity(
                        Long.parseLong(arr[0]),
                        Boolean.parseBoolean(arr[1]),
                        arr[2],
                        Double.parseDouble(arr[3]),
                        Double.parseDouble(arr[4]),
                        Boolean.parseBoolean(arr[5]),
                        Integer.parseInt(arr[6]),
                        Double.parseDouble(arr[7]),
                        Integer.parseInt(arr[8]),
                        world));
            }
            return world;
        }
    }
}
