/*Реализуйте метод subArrays, который принимает 
два массива целых чисел. Метод должен возвращать новый массив, где каждый 
элемент является разностью соответствующих элементов двух входных массивов. 
Если длины массивов не равны, выбрасывайте IllegalArgumentException с 
сообщением "Массивы разной длины". Если результат разности оказывается 
отрицательным, выбрасывайте RuntimeException с сообщением 
"Отрицательный результат разности".*/

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        Execute(new int[] { 10, 20, 30 }, new int[] { 5, 15, 25 });
        Execute(new int[] { 10, 20, 30 }, new int[] { 5, 15, 35 }); // Ожидаемый результат: исключение RuntimeException
        Execute(new int[] { 10, 20 }, new int[] { 5, 15, 25 }); // Ожидаемый результат: исключение
                                                                // IllegalArgumentException
    }

    static int[] subArrays(int[] a, int[] b) {
        if (a.length != b.length)
            throw new IllegalArgumentException("Массивы разной длины");
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = a[i] - b[i];
            if (res[i] < 0)
                throw new RuntimeException("Отрицательный результат разности");
        }
        return res;
    }

    static void Execute(int[] a, int[] b) {
        try {
            int[] result = subArrays(a, b);
            System.out.println(Arrays.toString(result));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
