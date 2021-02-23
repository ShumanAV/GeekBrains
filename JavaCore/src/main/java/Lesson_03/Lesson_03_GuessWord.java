package Lesson_03;

import java.util.Random;
import java.util.Scanner;

public class Lesson_03_GuessWord {
    //Версия 1.0.0

    public static void main(String[] args) {

        //* Создать массив из слов
        //String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
        // "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
        //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает,
        // правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
        //apple – загаданное
        //apricot - ответ игрока
        //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        //Для сравнения двух слов посимвольно можно пользоваться:
        //String str = "apple";
        //char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        //Играем до тех пор, пока игрок не отгадает слово.
        //Используем только маленькие буквы.
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int secretX = random.nextInt(words.length - 1);
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру Угадай слово, ваш ответ?");

        while (true) {
            String userAnswer = sc.nextLine();
            if (words[secretX].equals(userAnswer) == true) {
                System.out.println("Поздравляем, вы угадали слово!");
                break;
            } else {
                userAnswer = fillСhar(userAnswer);
                String word = "";
                for (int i = 0; i < words[secretX].length(); i++) {
                    if (words[secretX].charAt(i) == userAnswer.charAt(i)) {
                        word += userAnswer.charAt(i);
                    } else {
                        word += "#";
                    }
                }
                word = fillСhar(word);
                System.out.println("Вы не угадали слово, буквы, которые совпали с буквами загаданного слова " + word + ", ваш ответ?");
            }
        }

    }

    private static String fillСhar(String str) {
        for (int i = str.length(); i < 15; i++) {
            str += "#";
        }
        return str;
    }

}
