package Lesson_05;

public class Person {
    //ver 1.0.0

    private String name;
    private String position;
    private String email;
    private String phone;
    private float value;
    private int age;

    public Person(){
    }

    public Person(String name, String position, String email, String phone, float value, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.value = value;
        this.age = age;
    }

    public void setAge(int age){
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Возраст только положительный");
        }

    }

    public int getAge(){
        return this.age;
    }

    public void print(){
        System.out.printf("Сотрудник - %s, должность - %s, email - %s, телефон - %s, доход - %.2f, возраст - %d\n",
                name, position, email, phone, value, age);
    }

    public static void main(String[] args) {

    }

}
