/*
Создать абстрактный класс Animal с характеристиками животного.
Создать класс Horse который наследуется от Animal, в классе Horse реализовать метод public void run(){ System.out.println("Игого, я поскакал(а)"); }
Создать класс Pegasus который наследуется от Horse, в классе Pegasus реализовать метод public void fly(){ System.out.println("Игого, я полетел(а)"); }
Создать объект лошади и вызвать метод run();
Создать объект пегаса и вызвать метод fly();
*/

public class Main {
    public static void main(String[] args) {
        Horse horse = new Horse(5, "Лошадка");
        Pegasus pegasus = new Pegasus(6, "пегаска");
        horse.run();
        pegasus.fly();
    }
}

abstract class Animal {
    int age;
    String name;

    Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class Horse extends Animal {
    Horse(int age, String name) {
        super(age, name);
    }

    void run() {
        System.out.println("Игого, я поскакал(а)");
    }
}

class Pegasus extends Horse {
    Pegasus(int age, String name) {
        super(age, name);
    }

    void fly() {
        System.out.println("Игого, я полетел(а)");
    }
}
