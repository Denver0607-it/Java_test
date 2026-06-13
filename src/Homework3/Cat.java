package Homework3;

public class Cat extends Animal {

    private static int catCount = 0;
    private String name;
    private boolean isFull;

    public Cat(String name) {
        super();
        this.name = name;
        this.isFull = false;
        catCount++;

    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println(name + " не может пробежать " + distance + " м. (максимум 200 м.)");
        } else {
            System.out.println(name + " пробежал " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }

    public void eatFromBowl(Bowl bowl, int amount) {
        boolean success = bowl.eat(amount);
        if (success) {
            isFull = true;
            System.out.println(name + " покушал " + amount + " еды. Сыт!");
        } else {
            System.out.println(name + " не смог покушать — в миске только " + bowl.getFood() + " еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public String getName() {
        return name;
    }

    public static int getCatCount() {
        return catCount;
    }
}