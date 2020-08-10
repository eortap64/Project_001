package Lesson_006.other;

abstract class Animal {
    static int count = 0;
    String name;
    public Animal(String name) {
        this.name = name;
        count++;
    }
    public abstract void swim(int distance);
    public abstract void jump(double distance);
    public abstract void run(int distance);
    public static void printCount() {
        System.out.printf("Всего создано животных %d", count);
    }
}
class Cat extends Animal {
    static int count = 0;
    public Cat(String name) {
        super(name);
        count++;
    }
    @Override
    public void run(int distance) {
        int maxDistance = 200;
        if (distance > maxDistance) {
            System.out.printf("%s не может столько пробежать - %d м.\n", name, distance);
        } else {
            System.out.printf("%s пробежал %d метров\n", name, distance);
        }
    }
    @Override
    public void jump(double distance) {
        double maxDistance = 2.0;
        if (distance > maxDistance) {
            System.out.printf("%s не может так прыгать - %.3f м.\n", name, distance);
        } else {
            System.out.printf("%s прыгнул %.3f метров\n", name, distance);
        }
    }
    @Override
    public void swim(int distance) {
        System.out.printf("%s не умеет плавать\n", name);
    }
    public static void printCount() {
        System.out.printf("Всего создано котов %d\n", count);
    }
}
class Dog extends Animal {
    static int count = 0;
    public Dog(String name) {
        super(name);
        count++;
    }
    @Override
    public void swim(int distance) {
        int maxDistance = 10;
        if (distance > maxDistance) {
            System.out.printf("%s не может столько проплыть - %d м.\n", name, distance);
        } else {
            System.out.printf("%s проплыл %d метров\n", name, distance);
        }
    }
    @Override
    public void jump(double distance) {
        double maxDistance = 0.5;
        if (distance > maxDistance) {
            System.out.printf("%s не может так прыгать - %.3f м.\n", name, distance);
        } else {
            System.out.printf("%s прыгнул %.3f метров\n", name, distance);
        }
    }
    @Override
    public void run(int distance) {
        int maxDistance = 500;
        if (distance > maxDistance) {
            System.out.printf("%s не может столько пробежать - %d м.\n", name, distance);
        } else {
            System.out.printf("%s пробежал %d метров\n", name, distance);
        }
    }
    public static void printCount() {
        System.out.printf("Всего создано собак %d\n", count);
    }
}
public class Task_001 {
    public static void main(String[] args) {
        Animal cat1 = new Cat("Кот 1");
        Animal dog1 = new Dog("Пёс 1");
        Animal cat2 = new Cat("Кот 2");
        Animal dog2 = new Dog("Пёс 2");
        cat1.run(400);
        cat1.jump(1.8);
        cat1.swim(10);
        cat2.run(100);
        dog1.run(600);
        dog1.swim(10);
        dog2.jump(0.4);
        dog2.run(500);
        Cat.printCount();
        Dog.printCount();
        Animal.printCount();
    }
}