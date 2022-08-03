package cn.kk.base.utils;

public class MathHelper {

    public static double toProgress(double process) {
        return Math.ceil(process);
    }

    public static String toPercent(double process) {
        return String.format("%d", (int)(Math.ceil(process * 100))) + "%";
    }

    public static void main(String[] args) {


        System.out.println("50.1: " + toPercent(0.501));
    }
}
