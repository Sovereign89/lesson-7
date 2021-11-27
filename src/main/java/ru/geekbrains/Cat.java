package ru.geekbrains;

public class Cat {

    private final String name;
    private final int appetite;
    private final int fullness;
    private int currentFullness;
    private boolean full;

    public Cat(String name, int appetite, int fullness) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
        this.fullness = fullness;
        this.currentFullness = 0;
    }

    public boolean isFull() {
        return this.full;
    }

    public void isHungry() {
        if (!this.full) {
            System.out.printf("%s ещё голодный(ая). Осталось поесть %d еды. %n", this.name, this.fullness-this.currentFullness);
        } else {
            System.out.printf("%s не голодный(ая)!%n",this.name);
        }
    }

    public void eat(Plate p) {
        if (!this.full) {
            int eaten = p.decreaseFood(appetite);
            if (eaten > 0) {
                System.out.printf("%s поел(а) %d еды.%n", this.name, eaten);
                this.currentFullness += eaten;
            } else {
                System.out.printf("%s не смог(ла) поесть еды. Тарелка была пустой.%n", this.name);
            }
            this.full = this.currentFullness >= this.fullness;
        } else {
            System.out.printf("%s уже не голодный(ая)!%n",this.name);
        }
    }

    public String getName() {
        return name;
    }
}

