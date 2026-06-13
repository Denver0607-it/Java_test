package Homework3;

public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Dog dogRex = new Dog("Рекс");

        dogBobik.run(150);
        dogBobik.run(600);
        dogBobik.swim(5);
        dogBobik.swim(15);

        Cat[] cats = {
                new Cat("Мурзик"),
                new Cat("Барсик"),
                new Cat("Васька")
        };

        Bowl bowl = new Bowl(25);
        System.out.println("\nЕды в миске: " + bowl.getFood());

        int portion = 10;
        for (Cat cat : cats) {
            cat.eatFromBowl(bowl, portion);
        }

        bowl.addFood(20);
        System.out.println("Добавили еду. Теперь в миске: " + bowl.getFood());

        System.out.println("\n--- Сытость котов ---");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " + (cat.isFull() ? "сыт" : "голоден"));
        }

        System.out.println("\n--- Статистика ---");
        System.out.println("Собак создано: " + Dog.getDogCount());
        System.out.println("Котов создано: " + Cat.getCatCount());
    }
}
