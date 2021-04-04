package ru.StalkerNidus.labs.laba3;


import java.util.Scanner;

public class EntityPlayer extends Entity {
    private String nickname;
    private boolean n;

    public EntityPlayer() {
        super("player", 0, 0, false, 100, 100, 5);
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите ник: ");
        nickname = scan.next();
        n=true;
    }

    @Override
    public String toString() {
        return "EntityPlayer{" +
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
