package Lesson_004;
import java.util.Random;
import java.util.Scanner;
public class Task_002_003 {
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static int size;  // Размер поля
    public static int block; // Сколько должно быть одинаковых значение подряд для победы
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        new Task_002_003().go();
    }
    public void go() {
        customizeGame();
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победа Юзера!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Твоя очередь!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("ИИ победил!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Твоя очередь!");
                break;
            }
        }
        System.out.println("Игра окончена");
    }
    /** Запрашиваем размер поля и условия победы */
    void customizeGame() {
        do {
            System.out.print("Введите размер игрового поля [3-10]: ");
            size = sc.nextInt();
        } while(size<3 || size>10);
        do {
            System.out.print("Количество фишек? [3-"+size+"]: ");
            block = sc.nextInt();
        } while (block<3 || block>size);
    }
    /** Логика победы изменина для работы с любым размером поля. */
    boolean checkWin(char symb) {
        for (int col=0; col<size-block+1; col++) {
            for (int row=0; row<size-block+1; row++) {
                if (checkDiagonal(symb, col, row) || checkLanes(symb, col, row)) return true;
            }
        }
        return false;
    }
    /** Проверяем диагонали */
    boolean checkDiagonal(char symb, int offsetX, int offsetY) {
        boolean toright, toleft;
        toright = true;
        toleft = true;
        for (int i=0; i<block; i++) {
            toright &= (map[i+offsetX][i+offsetY] == symb);
            toleft &= (map[block-i-1+offsetX][i+offsetY] == symb);
        }
        return toright || toleft;
    }
    /** Проверяем горизонтальные и вертикальные линии */
    boolean checkLanes(char symb, int offsetX, int offsetY) {
        boolean cols, rows;
        for (int col=offsetX; col<block+offsetX; col++) {
            cols = true;
            rows = true;
            for (int row=offsetY; row<block+offsetY; row++) {
                cols &= (map[col][row] == symb);
                rows &= (map[row][col] == symb);
            }
            if (cols || rows) return true;
        }

        return false;
    }
    boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        } while (isCellValid(x, y));
        System.out.println("ИИ сделал ход: x=" + (x + 1) + " y=" + (y + 1));
        map[y][x] = DOT_O;
    }
    void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты: x=");
            x = sc.nextInt() - 1;
            System.out.print("y=");
            y = sc.nextInt() - 1;
        } while (isCellValid(x, y));
        map[y][x] = DOT_X;
    }
    boolean isCellValid(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) return true;
        return map[y][x] != DOT_EMPTY;
    }
    void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    void printMap() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

