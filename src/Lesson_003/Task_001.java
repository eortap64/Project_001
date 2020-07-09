package Lesson_003;
import java.util.Scanner;
import java.util.Random;
public class Task_001 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int guess = -1;
        int number = random.nextInt(10);
        while (count < 3 && guess != number) {
            System.out.print("Угадайте число (0..9): ");
            guess = sc.nextInt();
            if (number != guess) {
                System.out.println("Введённое число " +
                        ((guess > number) ? "крупно" : "мало"));
                count++;
            }
        }
        System.out.println("У вас " +
                ((guess == number) ? "победа!" : "провал: " + number));
        System.out.print("«Повторить игру еще раз? 1 – да / 0 – нет»: ");
        String userData = sc.next(); //ввод данных пользователя
        if (userData.equals("1")) { // сравниваем данные(0 или 1)введеные игроком с 1,
            // совпало? происходит возврат к методу main
            main(null);
        }
    }
}
