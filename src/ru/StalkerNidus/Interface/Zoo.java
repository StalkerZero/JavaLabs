package ru.StalkerNidus.Interface;

import java.util.Scanner;

public class Zoo {
    private String title;
    private EntityLiving[] animals;

    public Zoo(String title, EntityLiving[] animals) {
        this.title = title;
        this.animals = animals;
    }

/*
    public Zoo(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Название зоопарка:");
        title = scan.next();
        System.out.println("Сколько животных");
    }
*/

    public int getFlyEntityCount(){
        int n=0;
        for (EntityLiving i : animals) {
            if (i instanceof IFlyEntity) n++;
        }
        return n;
    }

    public int getPredatorEntityCount(){
        int n=0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] instanceof IPredator) n++;
        }
        return n;
    }

    public int getSoundEntityCount(){
        int n=0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] instanceof ISoundEntity) n++;
        }
        return n;
    }

    public void feedPredators(EntityLiving entity){
        if (!(entity instanceof IPredator)){
            for (int i = 0; i < animals.length; i++) {
                if (animals[i] instanceof IPredator) ((IPredator) animals[i]).hunt(entity);
            }
        }
        else System.out.println("Это хищник");
    }
}
