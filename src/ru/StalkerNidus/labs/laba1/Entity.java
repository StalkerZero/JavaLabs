package ru.StalkerNidus.labs.laba1;

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
        if (aggressive && life){
            Entity[] entities = GameServer.getInstance().getEntities();
            double distance=20;
            double sqrt;
            int id=-1;
            for (int i=0; i<idCounter-1; i++){
                sqrt=Math.sqrt(Math.pow(entities[i].getPosX()-posX, 2)+Math.pow(entities[i].getPosY()-posY, 2));
                if (distance>sqrt && !entities[i].isAggressive() && entities[i].isLife()){
                    id=i;
                    distance=sqrt;
                }
            }
            if (id>-1) {
                double pX = entities[id].getPosX() - posX;
                double pY = entities[id].getPosY() - posY;
                if (distance < 2 && entities[id].getHealth()>0) attack(entities[id]);
                else {
                    if (pX > 1) posX++;
                    else if (pX < -1) posX--;
                         else posX += pX;
                    if (pY > 1) posY++;
                    else if (pY < -1) posY--;
                         else posY += pY;
                }
            }
        }
    }

    public void attack(Entity entity) {
        entity.setHealth(entity.getHealth()-attackDamage-0.5*GameServer.getInstance().getDifficulty());
        if (entity instanceof EntityPlayer && entity.getHealth()>0){
            health=(health-entity.getAttackDamage()-0.5*GameServer.getInstance().getDifficulty());
        }
        if (entity.getHealth()<=0) {
            entity.setLife(false);
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