package ru.StalkerNidus.Computer;

public class Main {
    public static void main(String[] args){
        Computer c1 = new Computer(
                new CPU("i5-8400", 6, 3.0f, 4.0f),
                new GPU("rx 580", 1350, 4, false),
                new Memory[]{
                        new Memory(2667.1f, 8),
                        new Memory(2667.1f, 8)
                }
        );
        System.out.println(c1.toString());
        System.out.println(c1.getMemoriesBlocks()[1]);
    }
}
