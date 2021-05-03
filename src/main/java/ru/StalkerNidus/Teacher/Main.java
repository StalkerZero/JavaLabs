package ru.StalkerNidus.Teacher;

public class Main {
    public static void main(String[] args){
        Teacher t1 = new Teacher("Ivan", "Math", 10,
                new Group[]{
                        new Group("Y2335", 21),
                        new Group("Y2334", 18)
                });
        System.out.println(t1.toString());
        System.out.println(t1.hasGroup("Y2335"));
    }
}
