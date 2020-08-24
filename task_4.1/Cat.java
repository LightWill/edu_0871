/*
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true либо false, но должно выполняться условие:
если cat1.fight(cat2) возвращает true,
то cat2.fight(cat1) должен возвращать false.
Требования:
•	Класс Cat должен содержать конструктор без параметров.
•	Класс Cat должен содержать всего три поля: age, weight и strength. Поля должны быть публичные.
•	В классе Cat должен быть метод fight.
•	В методе fight реализовать механизм драки котов в зависимости от их веса, возраста и силы согласно условию.
•	Метод должен возвращать одно и тоже значение, если мы деремся с одним и тем же котом.
•	Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int leftOrRight = 0;

        if (age > anotherCat.age) leftOrRight -= 1;
        else if (age < anotherCat.age) leftOrRight += 1;

        if (weight > anotherCat.weight) leftOrRight -= 1;
        else if (weight < anotherCat.weight) leftOrRight += 1;

        if (strength > anotherCat.strength) leftOrRight -= 1;
        else if (strength < anotherCat.strength) leftOrRight += 1;
        
        return leftOrRight <= 0;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age = 6;
        cat1.strength = 8;
        cat1.weight = 5;
        Cat cat2 = new Cat();
        cat2.age = 7;
        cat2.strength = 9;
        cat2.weight = 4;

        System.out.println(cat1.fight(cat2));
    }
}
