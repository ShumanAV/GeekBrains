package Lesson_01;

public class Lesson_01 {
    //Версия 1.0.2

    public static void main(String[] args) {
        /*Создать переменные всех пройденных типов данных и инициализировать их значения.*/

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
        positiveOrNegative(10);
        System.out.println(positiveOrNegativeReturn(-1));
        stringOutput(name);
        leapYear(2024);

    }

    private static float calculation() {
/*        Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
            где a, b, c, d – аргументы этого метода, имеющие тип float.*/

        float a = 1.01f;
        float b = 2.02f;
        float c = 3.03f;
        float d = 4.04f;

        return a * (b + (c / d));
    }

    private static boolean from_10_to_20(int a, int b) {
/*        Написать метод, принимающий на вход два целых числа и проверяющий,
            что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.*/

        return a + b >= 10 && a + b <=20;
    }

    private static void positiveOrNegative(int a){
/*        Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
            положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.*/

        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    private static boolean positiveOrNegativeReturn(int a){
/*        Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное,
            и вернуть false если положительное.*/

        return a < 0;
    }

    private static void stringOutput(String name){
/*        Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».*/

        System.out.println("Привет, " + name + "!");
    }

    private static void leapYear(int year) {
/*        *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
            Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.*/

        if (year % 4 == 0 && year % 100 > 0 || year % 400 == 0){
            System.out.println(year + " - год високосный");
        } else {
            System.out.println(year + " - год обычный, не високосный");
        }
    }
}