package Lesson_003;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Task_002 {
    private static final short MAX_USER_ATTEMPT = 12; // кол-во угад., NO: 0 = бесконечно угад.
    private static final char[] CHAR_MASK = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
    private static Scanner inputScanner;
    private static Random randomGen;
    private static char[] charMask;
    private static final String[] words = {"apple", "orange", "lemon", "banana",
            "apricot", "avocado", "\nbroccoli", "carrot", "cherry", "garlic",
            "grape", "melon", "\nleak", "kiwi", "mango", "mushroom", "nut", "olive",
            "pea", "\npeanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private static final String[] successVar = {"Победа!"};
    private static final String[] loserVar = {"Нет!"};
    // Точка входа в приложение. "args" - параметры командной строки.
    public static void main(String[] args) {
        inputScanner = new Scanner(System.in);
        randomGen = new Random();
        ShowTitle();
        boolean answer = GetUserBooleanAnswer("Желаешь сыграть?");
        while (answer == true) {
            String wordMadeByMachine = WordGenerator(words);
            charMask = CHAR_MASK.clone();
            int userAttempt = 0;
            while (userAttempt <= MAX_USER_ATTEMPT) {
                String userInputWord = GetUserInput();
                if (wordMadeByMachine.equals(userInputWord)) {
                    Congratulation();
                    break;
                } else {
                    if(MAX_USER_ATTEMPT > 0) {
                        // Вариант игры с заданным кол-вом попыток
                        userAttempt++;
                        if(userAttempt < MAX_USER_ATTEMPT) {
                            Loser(userAttempt);
                        } else
                            break;
                    } else {
                        // Вариант игры с бесконечным угад.
                        Loser();
                    }
                    charMask = MakeMask(wordMadeByMachine, userInputWord, charMask);
                    ShowHelp(wordMadeByMachine, charMask);
                }
            }
            //При исчерпании попыток выводим загаданное слово
            if (MAX_USER_ATTEMPT > 0) {
                if (userAttempt == MAX_USER_ATTEMPT) {
                    System.out.printf("Ты проиграл, загаданное слово: %s\n", wordMadeByMachine);
                }
            }
            answer = GetUserBooleanAnswer("Хочешь ещё сыграть?");
        }
        inputScanner.close();
    }
    private static void ShowTitle() {
        System.out.print("Начало: ");
    }
    // wordMadeByMachine - слово, задуманное компьютером
    // charMask - маска подсказки
    private static void ShowHelp(final String wordMadeByMachine, final char[] charMask) {
        for (int i = 0; i < charMask.length; i++) {
            if (i < wordMadeByMachine.length()) {
                if (charMask[i] != '#') {
                    System.out.print(wordMadeByMachine.charAt(i));
                } else {
                    System.out.print(charMask[i]);
                }
            } else {
                System.out.print(charMask[i]);
            }
        }
        System.out.println();
    }
    // userInputWord - слово, введённое игроком
    private static char[] MakeMask(String wordMadeByMachine, String userInputWord, char[] oldMask) {
        char[] newMask;
        if (oldMask != null && oldMask.length > 1)
            newMask = oldMask.clone();
        else
            newMask = CHAR_MASK.clone();
        if (userInputWord != null && userInputWord.isEmpty() == false) {
            for (int i = 0; i < wordMadeByMachine.length(); i++) {
                if (i < userInputWord.length()) {
                    if (wordMadeByMachine.charAt(i) == userInputWord.charAt(i)) {
                        newMask[i] = ' ';
                    }
                }
            }
        }
        return newMask;
    }
    private static String GetUserInput() {
        System.out.println(Arrays.toString(words));
        System.out.print("Введи слово, загаданное компьютером: ");
        return inputScanner.nextLine().trim().toLowerCase();
    }
    private static boolean GetUserBooleanAnswer(final String question) {
        String input = "";
        while ((input.equals("Y") == false) && (input.equals("N") == false)) {
            System.out.printf("%s [ Y / N ] ", question);
            input = inputScanner.nextLine().trim().toUpperCase();
        }
        return input.equals("Y");
    }
    private static String WordGenerator(final String words[]) {
        int index = randomGen.nextInt(words.length);
        return words[index];
    }
    private static void Congratulation() {
        int index = randomGen.nextInt(successVar.length);
        System.out.printf("%s\n", successVar[index]);
    }
    // userAttempt номер попытки
    private static void Loser(final int userAttempt) {
        int index = randomGen.nextInt(loserVar.length);
        int amountAttempt = MAX_USER_ATTEMPT - userAttempt;
        System.out.printf("%s У тебя еще %d %s\n",
                loserVar[index],
                amountAttempt,
                amountAttempt == 1 ? "попытка" : "попытки");
    }
    private static void Loser() {
        int index = randomGen.nextInt(loserVar.length);
        System.out.printf("%s Пробуй ещё.\n", loserVar[index]);
    }
}
