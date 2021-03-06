package Lesson_05;

public class Lesson_05 {
    //ver 1.0.0

    public static void main(String[] args) {

        Person[] persArr = new Person[5];
        persArr[0] = new Person("Иванов Иван", "программист", "ivanov_1@yandex.ru", "+71231111111", 100000, 35);
        persArr[1] = new Person("Петров Петр", "инженер", "petrov@yandex.ru", "+71231111112", 120000, 45);
        persArr[2] = new Person("Сидоров Сидр", "тестер", "sidorov@yandex.ru", "+71231111113", 50000, 41);
        persArr[3] = new Person("Иванченко Иван", "тимлид", "ivanchenko@yandex.ru", "+71231111114", 150000, 38);
        persArr[4] = new Person("Иваненко Иван", "саппортер", "ivanenko@yandex.ru", "+71231111115", 70000, 33);

        persArr[0].setAge(43);       //эксперимент - использование сеттера

        for (int i = 0; i < persArr.length; i++) {
            if (persArr[i].getAge() >= 40) {
                persArr[i].print();
            }
        }
    }

}
