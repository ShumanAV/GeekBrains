package Lesson_06;

public class Cat extends Animal {
    static int numberCats;

    public Cat(){
        runDistanceMax = 100;
        swimDistanceMax = 0;
        numberCats ++;
        numberAnimals ++;
    }

    @Override
    void run(float length) {
        if (length > 0 && length <= runDistanceMax) {
            System.out.printf("Кот пробежал %.2f метров\n", length);
        } else if (length > runDistanceMax) {
            System.out.printf("Кот может бегать до %.2f метров\n", runDistanceMax);
        }
    }

    @Override
    void swim(float length) {
        if (length > 0 && length <= swimDistanceMax) {
            System.out.printf("Кот проплыл %.2f метров\n", length);
        } else if (length > swimDistanceMax) {
            System.out.printf("Кот не может плавать\n");
        }
    }

}
