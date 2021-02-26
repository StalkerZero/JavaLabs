package ru.StalkerNidus.Static;

public class Main {
    public static void main(String[] args){
        QuadraticEquation test1 = new QuadraticEquation(1, -9, -81);
        System.out.println(MathUtil.calculateQuadraticEquation(test1));
    }
}
