/*Напишите метод, который принимает массив строк и сортирует его в алфавитном порядке. 
ыЕсли входной массив null, метод должен вернуть пустой массив и вывести сообщение об ошибке. */

package lesson_2;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        String[] strings = args.length > 0 ? args : new String[] { "banana", "apple", "cherry" };
        String[] result = sortStrings(strings);
        System.out.println(Arrays.toString(result));
    }

    public static String[] sortStrings(String[] strings) {
        if (strings == null)
            return new String[0];
        String[] res = Arrays.copyOfRange(strings, 0, strings.length);
        Arrays.sort(res);
        return res;
    }
}
