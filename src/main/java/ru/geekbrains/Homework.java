package ru.geekbrains;

import java.util.Random;

public class Homework {

    public static void main(String[] args) {

        Cat[] cats = new Cat[8];
        cats[0] = new Cat("Маруська", 13, 32);
        cats[1] = new Cat("Мурзик", 18, 56);
        cats[2] = new Cat("Лапка", 4, 27);
        cats[3] = new Cat("Барсик", 9, 43);
        cats[4] = new Cat("Котёнок", 2, 17);
        cats[5] = new Cat("Рыжик", 7, 33);
        cats[6] = new Cat("Таша", 11, 38);
        cats[7] = new Cat("Пушок", 22, 74);
        Plate plate = new Plate(256);

        int allCatsFull;

        do {
            allCatsFull = 1;
            Cat randomCat = getRandomCat(cats);
            plate.info();
            if (!randomCat.isFull()) {
                randomCat.eat(plate);
            }
            randomCat.isHungry();


            for (Cat cat: cats) {
                if (!cat.isFull()) {
                    allCatsFull = 0;
                    break;
                }
            }

            if (allCatsFull > 0) {
                plate.info();
                break;
            }

        } while (plate.isFull());

        System.out.println("");
        int i = 1;
        for (Cat cat : cats) {
            int isFull = cat.isFull() ? 1 : 0;
            switch (isFull) {
                case 0:
                    System.out.printf("%d. %s голодный(ая).%n",i,cat.getName());
                    break;
                case 1:
                    System.out.printf("%d. %s не голодный(ая).%n",i,cat.getName());
                    break;
            }
            i++;
        }
    }

    public static Cat getRandomCat(@org.jetbrains.annotations.NotNull Cat[] array) {
        int randomCat = new Random().nextInt(array.length);
        return array[randomCat];
    }

}
