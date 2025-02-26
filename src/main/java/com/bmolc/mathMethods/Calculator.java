package com.bmolc.mathMethods;


public class Calculator {

    private static int a;
    private static int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static int multiplication() {
        return a * b;
    }

    public static int addition() {
        return a + b;
    }

    public static int subtraction() {
        return a - b;
    }

    public static double division() {
        return a / (double)b;
    }
}
