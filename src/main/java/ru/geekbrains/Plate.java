package ru.geekbrains;

public class Plate {
    private int food;
    private final int size;

    public Plate(int size) {
        this.food = size;
        this.size = size;
    }

    public int decreaseFood(int n) {
       int eaten = n;
       if (n>food) {
           eaten = n - (n-food);
           this.food -= eaten;
       } else {
           this.food -= n;
       }
       return eaten;
    }

    public void addFood(int n) {
        this.food += n;
        if (this.food > this.size) {
            System.out.println("Еды было добавлено больше, чем помещается в тарелке.");
            int surplus = this.food - this.size;
            this.food = this.size;
            System.out.printf("Остатки в количестве %d были выкинуты!%n",surplus);
        }
        info();
    }

    public boolean isFull() {
        return this.food > 0;
    }

    public void info() {
        if (this.food > 0) {
            System.out.printf("В тарелке осталось %d еды. %n", this.food);
        } else {
            System.out.println("В тарелке не осталось еды");
        }
    }
}
