package Lesson_07;

public class Cat {

    private String name;
    private int appetite;
    private boolean full;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void info(String name, boolean full) {
        System.out.printf("Кот - %s, сытый - %b\n", name, full);
    }

    public void eat(Plate p) {
        full = p.decreaseFood(appetite);
    }

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return full;
    }

}
