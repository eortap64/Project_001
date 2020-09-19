package Lesson_007;
import static java.lang.System.*;
class Plate {
    public int food;
    public Plate(int food) {
        this.food = food;
    }
    boolean decreaseFood(int n) {
        int diff = food - n;
        if (diff < 0) return false;
        food -= n;
        return true;
    }
    void addFood(int food) {
        this.food += food;
    }
    void info() {
        out.println("plate: " + food);
    }
}
class Cat {
    private String name;
    private int appetite;
    private boolean hungry;
    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }
    void info() {
        String isHungry = !hungry ? "сыт" : "голоден";
        out.println(name + ": " + isHungry);
    }
    void eat(Plate plate) {
        if (hungry && plate.decreaseFood(appetite))
            hungry = false;
    }
}
public class Task_001 {
    public static
    void main(String[] args) {
        Cat[] cats = {new Cat("Васька", 50), new Cat("Бонька", 50),
                new Cat("Снежок", 25), new Cat("Пушок", 5),
                new Cat("Тишка", 1)};
// наполнение миски и программа определения того, какой из котов сможет наесться
        Plate plate = new Plate( 80);
        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }
    }
}
