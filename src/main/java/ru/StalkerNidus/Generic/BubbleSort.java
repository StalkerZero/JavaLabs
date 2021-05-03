package ru.StalkerNidus.Generic;

public class BubbleSort<T extends Comparable> extends Sortinger<T> {
    @Override
    public void sort(T[] arr) {
        boolean sorted = false;
        T temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].compareTo(arr[i+1])==1) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    @Override
    public long sortWithTime(T[] arr) {
        return super.sortWithTime(arr);
    }
}
