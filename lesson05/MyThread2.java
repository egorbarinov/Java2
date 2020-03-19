package ru.gb.jtwo.le.hw;

public class MyThread2 extends Thread {
    private float[] arr;

    public MyThread2(float[] arr) {
        this.arr = arr;

    }

    @Override
    public void run() {
        System.out.println(getName() + " started");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
