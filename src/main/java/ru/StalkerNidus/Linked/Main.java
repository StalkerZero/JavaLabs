package ru.StalkerNidus.Linked;

public class Main {
    public static void main(String[] args){
//        new Thread(()->{
//            for (;;);
//        }).start();

        LinkedEntity le = new LinkedEntity();
        le.add(new LinkedEntity());
        le.add(new LinkedEntity());
        le.add(new LinkedEntity());

        System.out.println("size " + le.size());
        System.out.println("contain " + le.contains(3));

        le.add(new LinkedEntity());

        System.out.println("size " + le.size());
        System.out.println("contain " + le.contains(3));
        System.out.println("delete " + le.delete(3));

        System.out.println(le.toString());
    }
}
