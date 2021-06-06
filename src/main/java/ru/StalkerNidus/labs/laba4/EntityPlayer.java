package ru.StalkerNidus.labs.laba4;

import java.sql.SQLException;
import static ru.StalkerNidus.labs.laba4.DatabaseUtils.*;

public class EntityPlayer extends Entity {
    private String nickname;
    private double xp;
    private short upCount=0;
    private boolean n=true;

    public EntityPlayer(String nickname, long id, World world) throws SQLException {
        super( id, true, "player", 0, 0, false, 100, 100, 5, world);
        this.nickname=nickname;
        xp=selectXPPlayer(nickname);
    }

    public EntityPlayer(String nickname) throws SQLException {
        super( "player", 0, 0, false, 100, 100, 5);
        this.nickname=nickname;
        xp=0;
        insertPlayer(getId(), nickname, xp);
    }

    public EntityPlayer( String title, double posX, double posY, boolean aggressive, int maxHealth, double health, int attackDamage, String nickname, double xp) throws SQLException {
        super( title, posX, posY, aggressive, maxHealth, health, attackDamage);
        this.xp=xp;
        this.nickname = nickname;
        insertPlayer(getId(), nickname, xp);
    }

    public EntityPlayer(long id, boolean life, String title, double posX, double posY, boolean aggressive, int maxHealth, double health, int attackDamage, String nickname, double xp, World world) throws SQLException {
        super(id, life, title, posX, posY, aggressive, maxHealth, health, attackDamage, world);
        this.xp=xp;
        this.nickname = nickname;
        insertPlayer(id, nickname, xp);
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

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void update() throws SQLException {
        n=!n;
        upCount++;
        if (n && life && getHealth()<getMaxHealth()) setHealth(getHealth()+1);
        if (upCount==5){
            xp+=5*GameServer.getInstance().getConfig().getDifficulty();
            upCount=0;
        }
        super.update();
    }
}
