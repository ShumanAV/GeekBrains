package Lesson_06;

public class Dog extends Animal {
    static int numberDogs;

    public Dog(){
        runDistanceMax = 500;
        swimDistanceMax = 10;
        numberDogs ++;
        numberAnimals ++;
    }

    @Override
    void run(float length) {
        if (length > 0 && length <= runDistanceMax) {
            System.out.printf("Собака пробежала %.2f метров\n", length);
        } else if (length > runDistanceMax) {
            System.out.printf("Собака может бегать до %.2f метров\n", runDistanceMax);
        }

    }

    @Override
    void swim(float length) {
        if (length > 0 && length <= swimDistanceMax) {
            System.out.printf("Собака проплыла %.2f метров\n", length);
        } else if (length > swimDistanceMax) {
            System.out.printf("Собака может плавать до %.2f метров\n", swimDistanceMax);
        }
    }
}
