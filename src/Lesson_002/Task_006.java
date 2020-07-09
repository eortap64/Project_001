package Lesson_002;
public class Task_006 {
    static boolean checkBalance(int[] arr) {
        int lSumm, rSumm;
        for(int i = 0; i < arr.length + 1; i++) {
            lSumm = 0;
            rSumm = 0;
            for(int j = 0; j < i; j++) {
                lSumm += arr[j];
            }
            for(int j = i; j < arr.length; j++) {
                rSumm += arr[j];
            }
            if(lSumm == rSumm) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(checkBalance(new int[] {2, 2, 2, 1, 2, 2, 10, 1}));
        // checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) - true
        System.out.println(checkBalance(new int[] {2, 1, 1, 2, 1}));
        // checkBalance([2, 1, 1, || 2, 1]) - false
    }
}
