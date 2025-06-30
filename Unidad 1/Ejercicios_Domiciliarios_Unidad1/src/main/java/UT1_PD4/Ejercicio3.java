package UT1_PD4;

import java.awt.*;

public class Ejercicio3 {
    public  static class NumberHolder {
        public int anInt;
        public float aFloat;

    }
    public static void main(String[] args) {
        NumberHolder a=new NumberHolder();
        a.anInt=2;
        a.aFloat=3.14f;
        System.out.println(a.anInt);
        System.out.println(a.aFloat);
    }
}
