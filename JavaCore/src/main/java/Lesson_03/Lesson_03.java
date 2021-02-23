package Lesson_03;

import java.util.Random;
import java.util.Scanner;

public class Lesson_03 {
    //Версия 1.0.0

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
        //При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
        //После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        Random random = new Random();
        int secretNumber = 0;
        int numberAttempts = 3;
        int i = 0;
        while (i < numberAttempts + 2) {

            i++;
            switch (i) {
                case 1:
                    secretNumber = random.nextInt(9);
                    System.out.println("Добро пожаловать в игру Угадай число от 0 до 9, у вас есть количество попыток " + numberAttempts);
                    break;
                case 4:
                    System.out.println("Вы не угадали число " + secretNumber);
                    i = repeatGame();
                    continue;
            }

            int userNumber = sc.nextInt();
            if (userNumber > secretNumber) {
                System.out.println("Загаданное число меньше вашего, у вас осталось попыток " + (numberAttempts - i));
            } else if (userNumber < secretNumber){
                System.out.println("Загаданное число больше вашего, у вас осталось попыток " + (numberAttempts - i));
            } else {
                System.out.println("Поздравляем, вы угадали число " + secretNumber + " c " + i + " попытки");
                i = repeatGame();
            }
        }
        System.out.println("Спасибо за игру! До встречи.");

    }

    private static int repeatGame() {
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        if (sc.nextInt() == 1) {
            return 0;
        } else {
            return 5;
        }
    }

}
