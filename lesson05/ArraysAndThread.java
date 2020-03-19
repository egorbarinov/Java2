package ru.gb.jtwo.le.hw;

import java.util.Arrays;

public class ArraysAndThread {

    static final int size = 10000000;
    static final int h = size / 2;

    // 1. // 2. Создаем первый метод который будет создавать массив и заполнять его числами.
    // Отличие первого: Первый просто бежит по массиву и вычисляет значения.
    public static void calculateToArrays(int size) {
        float [] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        // 3. засечем время выполнения
        long a = System.currentTimeMillis();
        // 4. Проходим по всему массиву и для каждой ячейки считаем новое значение по формуле:
        //arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        // 5. В консоль выводится время работы:
        System.out.println(String.format("Execution time of the first method = %d", (System.currentTimeMillis() - a)));
    }
    //Создаем второй метод который будет создавать массив и заполнять его числами.
    //Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
    public static void calculateToArraysTwo (int size){
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.out.println(String.format("Time create the first half of the array  = %d", (System.currentTimeMillis() - a)));
        System.arraycopy(arr, h, arr2, 0, h);
        System.out.println(String.format("Time create the second half of the array = %d", (System.currentTimeMillis() - a)));

        Thread t1 = new Thread(new MyThread2(arr1));
        Thread t2 = new Thread(new MyThread2(arr2));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println(String.format("Execution time of the thread method = %d", (System.currentTimeMillis() - a)));
    }

    public static void main(String[] args) {
        // 1. Создаем первый метод который будет создавать массив и заполнять его числами
        ArraysAndThread.calculateToArrays(size); // Execution time of the first method = 4799
        // 2.
        ArraysAndThread.calculateToArraysTwo(size);
        // Time create the first half of the array  = 4
        // Time create the second half of the array = 8
        // Thread-0 started
        // Thread-2 started
        // Execution time of the thread method = 1336

    }
}
