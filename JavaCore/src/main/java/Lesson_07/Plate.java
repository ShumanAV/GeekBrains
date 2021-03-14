package Lesson_07;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            return true;
        } else {
            System.out.println("В тарелке недостаточно еды!");
        }
        return false;
    }

    public void increaseFood(int n) {
        food += n;
    }

    public void info() {
        System.out.printf("Осталось еды в тарелке: %d\n", food);
    }

}
