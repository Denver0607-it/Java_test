package Homework3;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public boolean eat(int amount) {
        if (amount > food) {
            return false;
        }
        food -= amount;
        return true;
    }

    public void addFood(int amount) {
        food += amount;
    }

    public int getFood() {
        return food;
    }
}
