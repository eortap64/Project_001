package Lesson_006.other;
abstract class Animal1 {
    private final int MAX_RUN_LENGTH = 0;
    private final int MAX_SWIM_LENGTH = 0;
    private final double MAX_JUMP_HEIGTH = 0;
    abstract void run(int length);
    abstract void swim(int length);
    abstract void jump(double height);
}
class Cat1 extends Animal1 {
    private final int MAX_RUN_LENGTH = 200;
    private final double MAX_JUMP_HEIGTH = 2;
    @Override
    void run(int length) {
        if ((length >= 0) && (length <= MAX_RUN_LENGTH)) System.out.print("run: false |");
        else System.out.print("run: true |");
    }
    @Override
    void swim(int length) {
        System.out.print("swim: false |");
    }
    @Override
    void jump(double height) {
        if ((height >= 0) && (height <= MAX_JUMP_HEIGTH)) System.out.println("jump: true");
        else System.out.print("jump: false");
    }
}
class Dog1 extends Animal1 {
    private final int MAX_RUN_LENGTH = 500;
    private final int MAX_SWIM_LENGTH = 10;
    private final double MAX_JUMP_HEIGTH = 0.5;
    @Override
    void run(int length) {
        if ((length >= 0) && (length <= MAX_RUN_LENGTH)) System.out.print("run: true |");
        else System.out.print("run: false |");
    }
    @Override
    void swim(int length) {
        if ((length >= 0) && (length <= MAX_SWIM_LENGTH)) System.out.print("swim: true |");
        else System.out.print("swim: false |");
    }
    @Override
    void jump(double height) {
        if ((height >= 0) && (height <= MAX_JUMP_HEIGTH)) System.out.println("jump: true");
        else System.out.println("jump: false");
    }
}
public class ReTask_000 {
    public static void main(String[] args) {
        Cat1 cat = new Cat1();
        System.out.println("Cat Barsik");
        cat.run(201);
        cat.swim(0);
        cat.jump(1.9);
        System.out.println("Cat Pushok");
        cat.run(189);
        cat.swim(0);
        cat.jump(1.73);
        System.out.println("Cat Tishka");
        cat.run(188);
        cat.swim(0);
        cat.jump(1.459);
        Dog1 dog = new Dog1();
        System.out.println("Dog Sharik");
        dog.run(500);
        dog.swim(10);
        dog.jump(0.4);
        System.out.println("Dog Bobik");
        dog.run(482);
        dog.swim(9);
        dog.jump(0.469);
        System.out.println("Dog Klyaxa");
        dog.run(234);
        dog.swim(4);
        dog.jump(0.485);
    }
}
