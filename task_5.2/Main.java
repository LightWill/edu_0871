
/*
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String login = scanner.nextLine();
//        System.out.println(login);
        System.out.println("Введите имя файла:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        Path fileName = Path.of(path);
        try {
            String content = Files.readString(fileName);
            content = content.replace("\n", " ").replace("\r", " ");
            String[] words = content.split(" ");
            System.out.println(content);
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                int a = Integer.parseInt(words[i]);
                res.add(a);
            }
            Collections.sort(res);
            for (int i = 0; i < res.size(); i++) {
                int aaa = res.get(i);
                if (aaa % 2 == 0) {
                    System.out.println(aaa);
                }
            }
        } catch (Exception except) {
            System.out.println("Ошибка:" + except);
        }
    }
}
