/*Реализуйте метод findAndReplace, который принимает массив строк, 
строку для поиска и строку для замены. Если искомая строка не найдена, 
добавьте сообщение об ошибке в список. 
Верните новый массив строк с выполненной заменой.*/

package lesson_1;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        Execute(new String[] { "apple", "banana", "cherry", "date" }, "banana", "orange");
        Execute(new String[] { "apple", "banana", "cherry", "date" }, "orange", "banana");
    }

    static String[] findAndReplace(String[] arr, String find, String replace) throws Exception {
        String[] res = new String[arr.length];
        boolean success = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != find) {
                res[i] = arr[i];
            } else {
                res[i] = replace;
                success = true;
            }
        }
        if (!success)
            throw new Exception("Строка не найдена");
        return res;
    }

    static void Execute(String[] arr, String find, String replace) {
        try {
            String[] result = findAndReplace(arr, find, replace);
            System.out.println("Результаты замены: " + Arrays.toString(result));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
