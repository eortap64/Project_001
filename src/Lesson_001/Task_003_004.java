package Lesson_001;
public class Task_003_004 {
    static void funcName(int a, int b, int c, int d) {
        System.out.println(a * (b + (c / d)));
        int h;
        h = a + b;
//      System.out.println("a+b="+h);
        if(h <= 20 && h >= 10) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    public static void main(String[] args) {
        int a = 9, b = 12, c = 4, d = 2;
        funcName(a, b, c, d);
    }
}
