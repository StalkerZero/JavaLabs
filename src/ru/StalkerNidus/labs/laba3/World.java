package ru.StalkerNidus.labs.laba3;

import java.util.*;

public class World {
    private int id = 1; //1
    private String worldName = "TestWorld"; //что угодно
    private List<Entity> entities = new ArrayList<>();

    public World(int id, String worldName, List<Entity> entities) {
        this.id = id;
        this.worldName = worldName;
        this.entities = entities;
    }

    public World(){}

    public void updateWorld(){
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
    }//возращает отсортированный в порядке близости точке x/z список сущностей в радиусе от x/z

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
    }//возращает отсортированный в порядке близости точке entity.posX/entity.posZ список сущностей

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
