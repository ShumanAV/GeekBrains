package Lesson_06;

public class App {
    //версия 1.0.2

    public static void main(String[] args) {

        Dog dog_1 = new Dog();
        dog_1.run(499);
        dog_1.swim(10);

        Dog dog_2 = new Dog();
        dog_2.run(501);
        dog_2.swim(11);

        Cat cat_1 = new Cat();
        cat_1.run(50);
        cat_1.swim(0);

        Cat cat_2 = new Cat();
        cat_2.run(101);
        cat_2.swim(1);

        System.out.println("Собак создано " + Dog.numberDogs);
        System.out.println("Котов создано " + Cat.numberCats);
        System.out.println("Животных создано " + Animal.numberAnimals);

    }

}
