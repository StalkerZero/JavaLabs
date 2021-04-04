package ru.StalkerNidus.Interface;

public class Vorobey extends EntityLiving implements IFlyEntity, ISoundEntity {
    private double maxFlyHeight;
    private double maxFlyTime;

    public Vorobey(String title, double maxFlyHeight, double maxFlyTime) {
        this.title = title;
        this.maxFlyHeight = maxFlyHeight;
        this.maxFlyTime = maxFlyTime;
        type = "птица";
    }

    @Override
    public double getMaxFlyHeight() {
        return maxFlyHeight;
    }

    @Override
    public double getMaxFlyTime() {
        return maxFlyTime;
    }

    @Override
    public String getSound() {
        return "чирик";
    }
}
