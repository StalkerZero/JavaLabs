package ru.StalkerNidus.Interface;

public class Horse extends EntityLiving implements ISoundEntity {
    public Horse(String title) {
        this.title=title;
        type = "млекопитающее";
    }

    @Override
    public String getSound() {
        return "Игого?";
    }
}
