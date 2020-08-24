/*
Создай классы Dog, Cat, Mouse.
Добавь по три поля в каждый класс, на твой выбор.
Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse("Jerry", 12 , 5),
где 12 - высота в см,
5 - длина хвоста в см.
Требования:
•	Создай класс Dog.
•	Создай класс Cat.
•	В классе Dog должно быть три переменные.
•	В классе Cat должно быть три переменные.
•	Должен быть создан хотя бы один объект типа Mouse.
•	Должен быть создан хотя бы один объект типа Dog.
•	Должен быть создан хотя бы один объект типа Cat.
*/

public class Main {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Cat tom = new Cat("Tom", 48, 20);
        Cat thomasina = new Cat("Thomasina", 36, 15);
        Dog spike =  new Dog("Spike", 96, 10);
    }
}

class Mouse extends Animal {
    Mouse(String name, int height, int tail) {
        super(name, height, tail);
    }
}

class Cat extends Animal {
    Cat(String name, int height, int tail) {
        super(name, height, tail);
    }
}

class Dog extends Animal {
    Dog(String name, int height, int tail) {
        super(name, height, tail);
    }
}

abstract class Animal {
    String name;
    int height;
    int tail;

    Animal(String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }
}
