/*Напишите приложение, которое будет запрашивать у пользователя следующие данные 
в произвольном порядке, разделенные пробелом: 
"Фамилия, Имя, Отчество, Дата Рождения, Номер Телефона, Пол". 

Форматы данных: 
• Фамилия, Имя, Отчество - строки 
• Дата Рождения - строка формата dd.mm.yyyy 
• Номер Телефона - целое беззнаковое число без форматирования
• Пол - символ латиницей f или m. 

Приложение должно проверить введенные данные по количеству. Если количество 
не совпадает с требуемым, вернуть код ошибки, обработать его и показать 
пользователю сообщение, что он ввел меньше или больше данных, чем требуется. 

Приложение должно попытаться распарсить полученные значения и выделить из них 
требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, 
соответствующее типу проблемы. Можно использовать встроенные типы Java и создать свои.
Исключение должно быть корректно обработано, пользователю выведено сообщение 
с информацией, что именно неверно. 

Если всё введено и обработано верно, должен создаться файл с названием,
равным фамилии, в него одну строку должны записаться полученные данные вида: 
<Фамилия><Имя><Отчество><Дата Рождения><Номер Телефона><Пол>.
Однофамильцы должны записаться в один и тот же файл, в отдельные строки. 
Не забудьте закрыть соединение с файлом. 

При возникновении проблемы с чтением или записью в файл, исключение должно быть
корректно обработано, пользователь должен увидеть стек-трейс ошибки. */

package lesson_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task1 {
    public static String[] forInput = new String[] {
            "Фамилия",
            "Имя",
            "Отчество",
            "Дата Рождения",
            "Номер Телефона",
            "Пол"
    };

    public static void main(String[] args) {
        String[] data = args.length == 6 ? args : args.length == 0 ? EnterData() : null;
        if (data == null || !isValid(data[3], data[4], data[5])) {
            System.out.println("Данные введены некорректно.");
            return;
        }
        writingInFile(data);
        System.out.println("Данные записаны в файл.");
    }

    public static String[] EnterData() {
        try (Scanner scan = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8.name()))) {
            String[] res = new String[forInput.length];
            for (int i = 0; i < forInput.length; i++) {
                System.out.println("Введите " + forInput[i]);
                res[i] = scan.nextLine();
            }
            return res;
        } catch (Exception e) {
            System.out.println("Ошибка при вводе: " + e.getMessage());
            return new String[0];
        }
    }

    public static boolean isValid(String birthday, String phone, String sex) {
        return birthday.matches("^[0-9]{2}[.]{1}[0-9]{2}[.]{1}[0-9]{4}$") &&
                phone.matches("^[0-9]+$") &&
                sex.matches("^[fFmM]{1}$");
    }

    public static void writingInFile(String[] data) {
        String fileName = "notes_for_" + data[0].toLowerCase() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (String element : data) {
                writer.write("<" + element + ">");
            }
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
