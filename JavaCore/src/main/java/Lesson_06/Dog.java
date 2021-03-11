package Lesson_06;

public class Dog extends Animal {
    static int numberDogs;

    Dog(){
        super(500, 10, "Бобик");
        numberDogs ++;
    }

}
