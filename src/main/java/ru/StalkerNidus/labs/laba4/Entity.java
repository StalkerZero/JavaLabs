package ru.StalkerNidus.labs.laba4;

import java.sql.SQLException;
import java.util.List;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.random;
import static ru.StalkerNidus.labs.laba4.DatabaseUtils.*;

public class Entity {
    protected final long id;
    protected boolean life;
    protected String title;
    protected double posX;
    protected double posY;
    protected boolean aggressive;
    protected int maxHealth;
    protected double health;
    protected int attackDamage;
    protected Entity target;
    protected World world;

    public Entity(String title) throws SQLException {
        id = insertEntity(title);
        life=true;
        this.title = title;
        posX=((random() * +20) + +-15);
        posY=((random() * +20) + +-15);
        switch (title){
            case "Rat":
                aggressive=true;
                health=maxHealth=50;
                attackDamage=3;
                break;
            case "Rabbit":
                aggressive=false;
                health=maxHealth=30;
                attackDamage=0;
                break;
        }
        world = GameServer.getInstance().getServerWorld();
    }

    public Entity(String title, double posX, double posY, boolean aggressive, int maxHealth, double health, int attackDamage) throws SQLException {
        id=insertEntity(title);
        life = true;
        this.title = title;
        this.posX = posX;
        this.posY = posY;
        this.aggressive = aggressive;
        this.maxHealth = maxHealth;
        this.health = health;
        this.attackDamage = attackDamage;
        world = GameServer.getInstance().getServerWorld();
    }

    public Entity(long id, boolean life, String title, double posX, double posY, boolean aggressive, int maxHealth, double health, int attackDamage, World world) {
        this.id = id;
        this.life = life;
        this.title = title;
        this.posX = posX;
        this.posY = posY;
        this.aggressive = aggressive;
        this.maxHealth = maxHealth;
        this.health = health;
        this.attackDamage = attackDamage;
        this.world = world;
    }

    public void update() throws SQLException {
        if (!aggressive) return;
        if (target == null) searchTarget();
        if (target == null) return;
        if (posX-target.getPosX()>1)posX--;
        else if (posX-target.getPosX()<-1) posX++;
             else posX+=posX-target.getPosX();
        if (posY-target.getPosY()>1)posY--;
        else if (posY-target.getPosY()<-1) posY++;
             else posY+=posY-target.getPosY();
        if (sqrt(pow((target.getPosX()-posX), 2)+pow((target.getPosY()-posY), 2))<2 && target.isLife()) attack(target);
    }

    public void searchTarget(){
        List<Entity> entities = GameServer.getInstance().getServerWorld().getEntitiesNearEntity(this, 20);
        for (Entity i : entities){
            if (!i.isAggressive() && i.isLife()){
                target = i;
                break;
            }
        }
    }

    public void attack(Entity entity) throws SQLException {
        entity.setHealth(entity.getHealth()-attackDamage-0.5* GameServer.getInstance().getConfig().getDifficulty());
        if (entity instanceof EntityPlayer && entity.getHealth()>0){
            health=(health-entity.getAttackDamage()-0.5* GameServer.getInstance().getConfig().getDifficulty());
        }
        if (entity.getHealth()<=0) {
            entity.setLife(false);
            target = null;
            if (entity instanceof EntityPlayer) System.out.println(title + " kill " + ((EntityPlayer) entity).getNickname());
            else System.out.println(title + " kill " + entity.getTitle());
            updateEntity(entity.getId());
            insertLogs(id, entity.getId());
        }
        if (health<=0) {
            life=false;
            if (entity instanceof EntityPlayer) {
                System.out.println(((EntityPlayer) entity).getNickname() + " kill " + title);
                ((EntityPlayer) entity).setXp(((EntityPlayer) entity).getXp()+GameServer.getInstance().getConfig().getDifficulty()*maxHealth);
                updatePlayer(entity.getId(), ((EntityPlayer) entity).getXp());
            }
            else System.out.println(entity.getTitle() + " kill " + title);
            updateEntity(id);
            insertLogs(entity.getId(), id);
        }
    }

    @Override
    public String toString() {
        return "\nEntity{" +
                "id=" + id +
                ", life=" + life +
                ", title='" + title + '\'' +
                ", posX=" + posX +
                ", posY=" + posY +
                ", aggressive=" + aggressive +
                ", maxHealth=" + maxHealth +
                ", health=" + health +
                ", attackDamage=" + attackDamage +
                '}';
    }

    public Entity getTarget() {
        return target;
    }

    public void setTarget(Entity target) {
        this.target = target;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posZ) {
        this.posY = posY;
    }

    public boolean isAggressive() {
        return aggressive;
    }

    public void setAggressive(boolean aggressive) {
        this.aggressive = aggressive;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}