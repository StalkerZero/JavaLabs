package ru.StalkerNidus.Generic;

public abstract class Sortinger<T extends Comparable> {
    public abstract void sort(T[] arr);
    public long sortWithTime(T[] arr){
        long ms = System.currentTimeMillis();
        sort(arr);
        return System.currentTimeMillis()-ms;
    }
}
