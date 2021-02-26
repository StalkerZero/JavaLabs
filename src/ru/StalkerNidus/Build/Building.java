package ru.StalkerNidus.Build;

import java.util.Scanner;

public class Building {
    private Address address;
    private BuildingType type;
    private int floorCount;

    public Building(){
        Scanner scan = new Scanner(System.in);
        String street;
        int index;
        int subIndex;
        int type1;

        System.out.println("Адрес здания:");
        street = scan.nextLine();
        System.out.println("Индекс здания:");
        index = scan.nextInt();
        System.out.println("Сабиндекс здания:");
        subIndex = scan.nextInt();
        address = new Address(street, index, subIndex);

        System.out.println("Тип здания(ОБЩЕСТВЕННОЕ - 1, ЖИЛОЕ - 2, ИНДУСТРИАЛЬНОЕ - 3):");
        type1 = scan.nextInt();
        if (type1==1) type = BuildingType.SOCIAL;
        else if (type1==2) type = BuildingType.LIVING;
        else type = BuildingType.INDUSTRIAL;

        System.out.println("Кол-во этажей:");
        floorCount = scan.nextInt();
    }

    public Building(Address address, BuildingType type, int floorCount) {
        this.address = address;
        this.type = type;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return "Building{" +
                "address=" + address +
                ", type=" + type +
                ", floorCount=" + floorCount +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BuildingType getType() {
        return type;
    }

    public void setType(BuildingType type) {
        this.type = type;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }
}
