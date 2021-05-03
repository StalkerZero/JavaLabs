package ru.StalkerNidus.Build;

import java.util.Arrays;
import java.util.Scanner;

public class City {
    private String title;
    private CityType type;
    private int population;
    private Building[] buildings;

    public boolean hasBuildByAddress(Address address){
        for(int i=0; i<buildings.length; i++){
            if(buildings[i].getAddress()==address) return true;
        }
        return false;
    }

    public Building getBuildingByAddress(Address address){
        for(int i=0; i<buildings.length; i++){
            if(buildings[i].getAddress()==address) return buildings[i];
        }
        return null;
    }

    public City(){
        Scanner scan = new Scanner(System.in);
        int k;

        System.out.println("Название города:");
        title = scan.next();
        System.out.println("Численность города: ");
        population = scan.nextInt();
        if (population>1000000) type = CityType.METROPOLIS;
        else if (population>50000) type = CityType.TOWN;
            else if (population>12000) type = CityType.URBAN_VILLAGE;
                else type = CityType.VILLAGE;
        System.out.println("Кол-во построек: ");
        k = scan.nextInt();
        buildings = new Building[k];
        for (int i=0; i<k; i++){
            buildings[i]= new Building();
        }
    }

    public City(String title, CityType type, int population, Building[] buildings) {
        this.title = title;
        this.type = type;
        this.population = population;
        this.buildings = buildings;
    }

    @Override
    public String toString() {
        return "City{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", population=" + population +
                ", buildings=" + Arrays.toString(buildings) +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CityType getType() {
        return type;
    }

    public void setType(CityType type) {
        this.type = type;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Building[] getBuildings() {
        return buildings;
    }

    public void setBuildings(Building[] buildings) {
        this.buildings = buildings;
    }
}
