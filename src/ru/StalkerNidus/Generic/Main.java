package ru.StalkerNidus.Generic;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Double[] arr = new Double[100000];
        Random rand = new Random();
        for (int i = 0; i < 100000; i++) arr[i]=rand.nextDouble();
        System.out.println("bubble " + new BubbleSort<>().sortWithTime(arr) + "ms");
        for (int i = 0; i < 100000; i++) arr[i]=rand.nextDouble();
        System.out.println( "insertion " + new Insertion<>().sortWithTime(arr) + "ms");
        for (int i = 0; i < 100000; i++) arr[i]=rand.nextDouble();
        System.out.println( "selection " + new Selection<>().sortWithTime(arr) + "ms");
        for (int i = 0; i < 100000; i++) arr[i]=rand.nextDouble();
        System.out.println( "heap " + new Heap<>().sortWithTime(arr) + "ms");
    }
}
