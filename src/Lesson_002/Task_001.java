package Lesson_002;
public class Task_001 {
    public static void main(String[] args) {
        int[] mass = {1, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        int maxMass = mass.length;
        for (int i : mass) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int a = 0; a < maxMass; a++)
            if (mass[a] == 1) {
                mass[a] = 0;
            } else mass[a] = 1;
        for (int i : mass) {
            System.out.print(i + " ");
        }
    }
}
