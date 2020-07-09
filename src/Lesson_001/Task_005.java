package Lesson_001;
public class Task_005 {
    static void funcName(int x) {
        if (x >= 0) {
            System.out.println("положительное");
        } else {
            System.out.println("отрицательное");
        }
    }
    public static void main(String[] args) {
        int x = 64;
        funcName(x);
    }
}
