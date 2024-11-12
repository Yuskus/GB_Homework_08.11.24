/*Напишите метод,который проверяет, является ли введенная строка
 палиндромом. Если строка палиндром, возвращайте "Palindrome".
 Если нет — "Not a palindrome".*/

package lesson_2;

public class Task2 {
    public static void main(String[] args) {
        String input = args.length > 0 ? args[0] : "A man a plan a canal Panama";
        System.out.println("Is the input a palindrome? " + isPalindrome(input));
    }

    public static boolean isPalindrome(String input) {
        if (isNullOrWhiteSpace(input))
            return false;

        char[] letters = input.replace(" ", "")
                .toUpperCase()
                .toCharArray();

        for (int i = 0; i < letters.length / 2; i++) {
            if (letters[i] != letters[letters.length - 1 - i])
                return false;
        }
        return true;
    }

    public static boolean isNullOrWhiteSpace(String str) {
        return str == null || str.trim().isEmpty();
    }
}
