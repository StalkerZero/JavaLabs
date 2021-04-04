package ru.StalkerNidus.labs.laba2;

import java.util.List;

public class Entity {
    private static int idCounter = 1;
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
    protected World world = GameServer.getInstance().getServerWorld();

    public Entity(String title){
        id = idCounter;
        idCounter++;
        life=true;
        this.title = title;
        posX=((Math.random() * +20) + +-15);
        posY=((Math.random() * +20) + +-15);
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
    }

    public Entity(String title, double posX, double posY, boolean aggressive, int maxHealth, double health, int attackDamage) {
        id = idCounter;
        idCounter++;
        life = true;
        this.title = title;
        this.posX = posX;
        this.posY = posY;
        this.aggressive = aggressive;
        this.maxHealth = maxHealth;
        this.health = health;
        this.attackDamage = attackDamage;
    }

    public void update() {
        if (!aggressive) return;
        if (target == null) searchTarget();
        if (target == null) return;
        if (posX-target.getPosX()>1)posX--;
        else if (posX-target.getPosX()<-1) posX++;
             else posX+=posX-target.getPosX();
        if (posY-target.getPosY()>1)posY--;
        else if (posY-target.getPosY()<-1) posY++;
             else posY+=posY-target.getPosY();
        if (Math.sqrt((target.getPosX()-posX)*(target.getPosX()-posX)+(target.getPosY()-posY)*(target.getPosY()-posY))<2 && target.isLife()) attack(target);
    }

    public void searchTarget(){
        List<Entity> entities = GameServer.getInstance().getServerWorld().getEntitiesNearEntity(this, 20);
        System.out.println(GameServer.getInstance().getServerWorld().getEntitiesNearEntity(this, 20));
        for (Entity i : entities){
            if (!i.isAggressive() && i.isLife()){
                target = i;
                break;
            }
        }
    }

    public void attack(Entity entity) {
        entity.setHealth(entity.getHealth()-attackDamage-0.5* GameServer.getInstance().getDifficulty());
        if (entity instanceof EntityPlayer && entity.getHealth()>0){
            health=(health-entity.getAttackDamage()-0.5* GameServer.getInstance().getDifficulty());
        }
        if (entity.getHealth()<=0) {
            entity.setLife(false);
            target = null;
            if (entity instanceof EntityPlayer) System.out.println(title + " kill " + ((EntityPlayer) entity).getNickname());
            else System.out.println(title + " kill " + entity.getTitle());
        }
        if (health<=0) {
            life=false;
            if (entity instanceof EntityPlayer) System.out.println(((EntityPlayer) entity).getNickname() + " kill " + title);
            else System.out.println(entity.getTitle() + " kill " + title);
        }
    }

    @Override
    public String toString() {
        return "Entity{" +
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