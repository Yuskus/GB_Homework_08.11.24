/*Напишите метод,который проверяет,является ли введенная строка корректной
 датой в формате "YYYY-MM-DD". Дата должна быть в пределах от 0001-01-01
 до 9999-12-31. Если дата корректна, возвращайте её.Если нет — сообщение
 об ошибке.*/

package lesson_2;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        String date;
        date = args.length > 0 ? args[0] : "2024-09-01";
        String result = validateDate(date);
        System.out.println(result);
    }

    public static String validateDate(String date) {
        if (!date.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$"))
            return "Формат даты не подходит";

        int[] arr = Arrays.asList(date.split("-")).stream().mapToInt(Integer::parseInt).toArray();

        if (isDateOutOfRange(arr[0], arr[1], arr[2])) {
            return "Формат даты выходит за границы диапазона";
        } else {
            if (isLeapYear(arr[0], arr[1], arr[2]))
                return date;
            int[] monthDays = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            if (arr[2] > monthDays[arr[1]])
                return "Формат даты выходит за границы диапазона";
        }
        return date;
    }

    private static boolean isDateOutOfRange(int year, int month, int day) {
        return year < 1 || year > 9999 || month < 1 || month > 12 || day < 1 || day > 31;
    }

    // Метод для проверки високосного года
    private static boolean isLeapYear(int year, int month, int day) {
        return month == 2 && day == 29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }
}