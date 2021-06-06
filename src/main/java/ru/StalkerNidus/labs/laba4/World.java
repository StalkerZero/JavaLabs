package ru.StalkerNidus.labs.laba4;

import java.sql.SQLException;
import java.util.*;

public class World {
    private int id = 1;
    private String worldName = "TestWorld";
    private List<Entity> entities = new ArrayList<>();

    public World(int id, String worldName, List<Entity> entities) {
        this.id = id;
        this.worldName = worldName;
        this.entities = entities;
    }

    public World(int id, String worldName) {
        this.id = id;
        this.worldName = worldName;
    }

    public World() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.print("How much Rats? ");
        int rat=scan.nextInt();
        System.out.print("How much Rabbits? ");
        int rabb=scan.nextInt();
        System.out.print("How much Players? ");
        int play=scan.nextInt();
        for (int i = 0; i < rat+rabb+play; i++) {
            if (i<rat) entities.add(new Entity("Rat"));
            else if (i<rat+rabb) entities.add(new Entity("Rabbit"));
            else {
                scan = new Scanner(System.in);
                System.out.print("Введите ник: ");
                String nickname = scan.next();
                long id = DatabaseUtils.selectIDPlayer(nickname);
                if (id==0) entities.add(new EntityPlayer(nickname));
                else entities.add(new EntityPlayer(nickname, id, this));
            }
        }
    }

    public void updateWorld() throws SQLException {
        for (int i = entities.size()-1; i >= 0; i--) {
            if (!entities.get(i).isLife()) entities.remove(i);
            else entities.get(i).update();
        }
    }

    public List<Entity> getEntitiesInRegion(double x, double z, double range){
        List<Entity> entities1 = new ArrayList<>();
        Map<Long, Double> entityMap= new HashMap<>();
        for (Entity i : entities){
            double sqrt = Math.sqrt(Math.pow((i.getPosX()-x), 2) + Math.pow((i.getPosY()-z), 2));
            if (sqrt<range){
                entityMap.put(i.getId(), sqrt);
                entities1.add(i);
            }
        }
        return sort(entities1, entityMap);
    }

    public List<Entity> getEntitiesNearEntity(Entity entity, double range){
        List<Entity> entities1 = new ArrayList<>();
        Map<Long, Double> entityMap= new HashMap<>();
        for (Entity i : entities){
            double sqrt = Math.sqrt(Math.pow((i.getPosX()-entity.getPosX()), 2) + Math.pow((i.getPosY()-entity.getPosY()), 2));
            if (sqrt<range){
                entityMap.put(i.getId(), sqrt);
                entities1.add(i);
            }
        }
        return sort(entities1, entityMap);
    }

    public List<Entity> sort(List<Entity> entities1, Map<Long, Double> entityMap){
        Collections.sort(entities1, new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                return Double.compare(entityMap.get(o1.getId()), entityMap.get(o2.getId()));
            }
        });
        return entities1;
    }

    @Override
    public String toString() {
        return "World{" +
                "id=" + id +
                ", worldName='" + worldName + '\'' +
                ", entities=" + entities +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }
}
