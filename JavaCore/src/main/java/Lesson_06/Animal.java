package Lesson_06;

public abstract class Animal {

    static int numberAnimals;
    protected float runDistanceMax;
    protected float swimDistanceMax;

    abstract void run(float length);

    abstract void swim(float length);


}
