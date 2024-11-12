/*Напишите метод, который находит среднее значение массива целых чисел. 
Если массив пустой или null, метод должен вернуть Double.NaN 
и вывести сообщение об ошибке.*/

package lesson_2;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] array = args.length > 0 ? ConvertToIntArray(args) : new int[] { 10, 20, 30, 40, 50 };
        System.out.println(findAverage(array));
    }

    public static double findAverage(int[] array) {
        if (array == null || array.length == 0)
            return Double.NaN;
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public static int[] ConvertToIntArray(String[] args) {
        try {
            return Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            System.out.println("Ошибка преобразования массива. Текст ошибки: " + e.getMessage());
            return new int[0];
        }
    }
}
