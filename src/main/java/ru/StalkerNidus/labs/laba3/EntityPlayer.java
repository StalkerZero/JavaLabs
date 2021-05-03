package ru.StalkerNidus.labs.laba3;


import java.util.Scanner;

public class EntityPlayer extends Entity {
    private String nickname;
    private boolean n;

    public EntityPlayer() {
        super( "player", 0, 0, false, 100, 100, 5);
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите ник: ");
        nickname = scan.next();
        n=true;
    }

    public EntityPlayer( String title, double posX, double posY, boolean aggressive, int maxHealth, double health, int attackDamage, String nickname) {
        super( title, posX, posY, aggressive, maxHealth, health, attackDamage);
        this.nickname = nickname;
    }

    public EntityPlayer(long id, boolean life, String title, double posX, double posY, boolean aggressive, int maxHealth, double health, int attackDamage, String nickname, World world) {
        super(id, life, title, posX, posY, aggressive, maxHealth, health, attackDamage, world);
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "\nEntityPlayer{" +
                "id=" + id +
                ", life=" + life +
                ", title='" + title + '\'' +
                ", posX=" + posX +
                ", posY=" + posY +
                ", aggressive=" + aggressive +
                ", maxHealth=" + maxHealth +
                ", health=" + health +
                ", attackDamage=" + attackDamage +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void update() {
        n=!n;
        if (n && life){
            if (getHealth()<getMaxHealth()){
                setHealth(getHealth()+1);
            }
        }
        super.update();
    }
}
