package Lesson_002;
public class Task_004 {
    public static void main(String[] args) {
        int[][] mass1 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < j) {
                    mass1[i][j] = 0;
                } else if (i > j) {
                    mass1[i][j] = 0;
                } else {
                    mass1[i][j] = 1;
                }
                System.out.print(mass1[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

