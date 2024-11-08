/*Реализуйте метод convertAndSum, который принимает массив строк, 
каждая из которых должна быть преобразована в целое число. Метод 
возвращает сумму всех чисел. Если хотя бы одна строка не может быть 
преобразована в число, метод должен выбросить исключение NumberFormatException. 
Дополнительно, если сумма чисел превышает 100, выбрасывайте 
ArithmeticException с сообщением "Превышен лимит суммы".*/

public class Task1 {
    public static void main(String[] args) {
        Execute(new String[] { "10", "20", "70" }); // корректный ввод: ожидаемый результат: 100
        Execute(new String[] { "10", "20", "abc" }); // ввод с некорректным числом: исключение NumberFormatException
        Execute(new String[] { "50", "60" }); // сумма превышает лимит: исключение ArithmeticException
    }

    public static int convertAndSum(String[] strings) {
        Integer sum = 0;
        for (int i = 0; i < strings.length; i++) {
            sum += Integer.parseInt(strings[i]); // он итак бросает NumberFormatException, если парсинг не удался
        }
        if (sum > 100)
            throw new ArithmeticException("Превышен лимит суммы");
        return sum;
    }

    public static void Execute(String[] strings) {
        try {
            System.out.println(convertAndSum(strings));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}