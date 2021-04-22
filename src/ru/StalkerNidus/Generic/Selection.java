package ru.StalkerNidus.Generic;

public class Selection<T extends Comparable> extends Sortinger<T> {
    @Override
    public void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T min = array[i];
            int minId = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j].compareTo(min)==-1 ) {
                    min = array[j];
                    minId = j;
                }
            }
            // замена
            T temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }

    @Override
    public long sortWithTime(T[] arr) {
        return super.sortWithTime(arr);
    }
}
