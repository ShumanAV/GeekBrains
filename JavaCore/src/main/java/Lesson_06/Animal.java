package Lesson_06;

public abstract class Animal {

    static int numberAnimals;
    protected float runDistanceMax;
    protected float swimDistanceMax;
    protected String name;

    protected Animal(float runDistanceMax, float swimDistanceMax, String name){
        this.runDistanceMax = runDistanceMax;
        this.swimDistanceMax = swimDistanceMax;
        this.name = name;
        numberAnimals ++;
    }

    protected void run(float length) {
        if (length > 0 && length <= runDistanceMax) {
            System.out.printf("%s пробежал %.2f метров\n", name, length);
        } else if (length > runDistanceMax) {
            System.out.printf("%s может бегать до %.2f метров\n", name, runDistanceMax);
        }
    }

    protected void swim(float length) {
        if (length > 0 && length <= swimDistanceMax) {
            System.out.printf("%s проплыл %.2f метров\n", name, length);
        } else if (length > swimDistanceMax) {
            System.out.printf("%s может плавать до %.2f метров\n", name, swimDistanceMax);
        }
    }


}
