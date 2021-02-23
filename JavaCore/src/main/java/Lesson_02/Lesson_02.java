package Lesson_02;

import java.util.Arrays;

public class Lesson_02 {
    //Версия 1.0.0

    public static void main(String[] args) {

        /*1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;*/
        int[] arrayInt = {1, 0, 0, 1, 0, 1, 1, 1, 0};
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = (arrayInt[i] - 1) * (-1);
        }
        System.out.println(Arrays.toString(arrayInt));

        /*2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;*/
        int[] arrayInt_2 = new int[8];
        for (int i = 1; i < arrayInt_2.length; i++) {
            arrayInt_2[i] = arrayInt_2[i-1] + 3;
        }
        System.out.println(Arrays.toString(arrayInt_2));

        /*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;*/
        int[] arrayInt_3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrayInt_3.length; i++) {
            if (arrayInt_3[i] < 6){
                arrayInt_3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arrayInt_3));

        /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;*/
        int[][] arrayInt_4 = new int[5][5]; //работает для квадрата четных и нечетных чисел, например 3*3, 4*4, 5*5 и т.д.
        for (int i = 0; i < arrayInt_4.length; i++) {
            arrayInt_4[i][i] = 1;
            if (i != (int) arrayInt_4.length / 2 || arrayInt_4.length % 2== 0)
                arrayInt_4[i][arrayInt_4.length - i - 1] = 1;
            System.out.println(Arrays.toString(arrayInt_4[i]));
        }

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] arrayInt_5 = {-5, -3, -2, -4, -1, -6, -7, -15, -1, -2, -8};
        System.out.println("Минимальное значение массива " + arrayMin(arrayInt_5));
        System.out.println("Максимальное значение массива " + arrayMax(arrayInt_5));

        //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место,
        // в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        int[] arrayInt_6 = {-1, -1, -2, 0, -4};
        System.out.println("В данном массиве сумма левой и правой части равны - " + sumLeftRight(arrayInt_6));

        //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        // При каком n в какую сторону сдвиг можете выбирать сами.
        int[] arrayInt_7 = {1, 2, 3, 4, 5, 6, 7};
        int n = 3;
        offsetArray(arrayInt_7, n);

    }

    private static int arrayMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        return min;
    }

    private static int arrayMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }

    private static boolean sumLeftRight(int[] arr) {
        int sumLeft = 0;
        for (int i = 0; i < arr.length; i++) {
            sumLeft = sumLeft + arr[i];
            int sumRight = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sumRight = sumRight + arr[j];
            }
            if (sumLeft == sumRight && i != arr.length - 1)
                return true;
        }
        return false;
    }

    private static void offsetArray(int[] arr, int n){
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                int buffer_1 = arr[0];
                int buffer_2 = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (j == arr.length - 1) {
                        arr[0] = buffer_1;
                        break;
                    }
                    buffer_2 = arr[j + 1];
                    arr[j + 1] = buffer_1;
                    buffer_1 = buffer_2;
                }
            }
        } else {
            n = n * -1;
            for (int i = 0; i < n; i++) {
                int buffer_1 = arr[arr.length - 1];
                int buffer_2 = 0;
                for (int j = arr.length - 1; j >= 0; j--) {
                    if (j == 0) {
                        arr[arr.length - 1] = buffer_1;
                        break;
                    }
                    buffer_2 = arr[j - 1];
                    arr[j - 1] = buffer_1;
                    buffer_1 = buffer_2;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
