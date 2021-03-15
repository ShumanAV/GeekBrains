package Lesson_07;

public class App {
    //ver 1.0.1

    public static void main(String[] args) {

        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Barsik", 5);
        cat[1] = new Cat("Alisa", 7);
        cat[2] = new Cat("Vasiliy", 10);

        Plate plate = new Plate(20);
        plate.increaseFood(1);

        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate);
            cat[i].info(cat[i].getName(), cat[i].isFull());
        }
        plate.info();

    }

}
