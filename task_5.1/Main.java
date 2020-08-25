/*
        Перед решением прочтите https://www.codeflow.site/ru/article/java-buffered-reader
        Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
        Новая задача: Программа должна работать не с номерами домов, а с городами:
        Пример ввода:
        Москва
        Ивановы
        Киев
        Петровы
        Лондон
        Абрамовичи
        Лондон
        Пример вывода:
        Абрамовичи */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> families = new ArrayList<>();
        ArrayList<String> cities = new ArrayList<>();
        while (true) {
            System.out.println("Введите город:");
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }

            System.out.println("Введите фамилию:");
            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }

            cities.add(city);
            families.add(family);
        }

        System.out.println("Введите город:");
        String city = reader.readLine();

        int cityNumber = cities.indexOf(city);

        if (cityNumber != -1) {
            String familyName = families.get(cityNumber);
            System.out.println(familyName);
        }
    }
}
