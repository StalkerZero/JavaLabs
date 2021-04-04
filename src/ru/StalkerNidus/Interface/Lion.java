package ru.StalkerNidus.Interface;

public class Lion extends EntityLiving implements ISoundEntity, IPredator {
    public Lion(String title) {
        this.title = title;
        type = "млекопитающее";
    }

    @Override
    public void hunt(EntityLiving entity) {
        System.out.println(title + " ест " + entity.title);
    }

    @Override
    public String getSound() {
        return "(пафосное) Мяу";
    }
}
