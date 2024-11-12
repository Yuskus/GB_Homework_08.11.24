/*Реализуйте метод mergeAndValidateArrays, который принимает два массива целых чисел. 
Метод должен объединить массивы и вернуть новый массив. Если длины массивов не равны, 
выбрасывайте исключение IllegalArgumentException. Если хотя бы один элемент объединенного 
массива отрицательный, выбрасывайте исключение RuntimeException с сообщением 
"Обнаружен отрицательный элемент".*/

package lesson_1;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        Execute(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 });
        Execute(new int[] { 1, 2 }, new int[] { 3, 4, 5 });
        Execute(new int[] { -1, 2, 3 }, new int[] { 4, 5, 6 });
    }

    static int[] mergeAndValidateArrays(int[] a, int[] b) {
        if (a.length != b.length)
            throw new IllegalArgumentException();
        int[] res = new int[a.length * 2];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0 || b[i] < 0)
                throw new RuntimeException("Одно из чисел отрицательно");
            res[i] = a[i];
            res[i + a.length] = b[i];
        }
        return res;
    }

    static void Execute(int[] a, int[] b) {
        try {
            int[] result = mergeAndValidateArrays(a, b);
            System.out.println(Arrays.toString(result)); // Ожидаемый результат: исключение RuntimeException
        } catch (IllegalArgumentException e) {
            System.out.println("Длины массивов не равны");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
