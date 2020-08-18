/* Задача наполнить корабельный бассейн. Нужно посчитать, сколько литров воды нужно для заполнения бассейна до бортов.
Известно, что бассейн имеет линейные размеры a × b × c, заданные в метрах.
Эти размеры передаются запрашиваются у пользователя. Прграмма должена вывести на экран количество литров воды,
которое нужно для наполнения бассейна.
Пример:
Пользователь даёт числа 25, 5, 2.
Пример вывода:
250000 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите высоту:");
        int a = scanner.nextInt();
        System.out.println("Введите ширину:");
        int b = scanner.nextInt();
        System.out.println("Введите глубину:");
        int c = scanner.nextInt();
        int v = a * b * c;

        System.out.println("Объём: " + v);
    }
}
