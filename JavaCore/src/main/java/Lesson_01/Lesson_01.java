package Lesson_01;

public class Lesson_01 {

    public static void main(String[] args) {

        byte a = 11;
        short b = 1111;
        int c = 111111;
        long d = 1111111111;

        float f = 0.1221f;
        double dbl = 0.22222112;

        char chr = 'a';

        String name = "Alexandr";

        System.out.println(calculation());
        System.out.println(from_10_to_20(5, 10));
        positiveOrNegative(-10);
        System.out.println(positiveOrNegativeReturn(-5));
        stringOutput(name);
        leapYear(2021);

    }

    private static float calculation() {
        float a = 1.01f;
        float b = 2.02f;
        float c = 3.03f;
        float d = 4.04f;

        return a * (b + (c / d));
    }

    private static boolean from_10_to_20(int a, int b) {
        if (a + b >= 10 && a + b <=20) {
            return true;
        } else {
            return false;
        }
    }

    private static void positiveOrNegative(int a){
        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    private static boolean positiveOrNegativeReturn(int a){
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void stringOutput(String name){
        System.out.println("Привет, " + name);
    }

    private static void leapYear(int year) {
        if (year % 4 == 0 && year % 100 > 0 || year % 400 == 0){
            System.out.println("Год високосный");
        } else {
            System.out.println("Год обычный, не високосный");
        }
    }
}