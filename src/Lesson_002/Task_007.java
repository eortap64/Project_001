package Lesson_002;
public class Task_007 {
    static void modifyArray(int[] arr, int n) {
        System.out.print("До прокрутки ряда на ");
        if(n < 0) {
            System.out.print(-n + " места  влево: ");
        } else if(n > 0) {
            System.out.print(n + " места вправо: ");
        } else {
            System.out.print(n + " мест вникуда: ");
        }
        for(int i : arr) {
            System.out.print(i + " ");
        }
        if(n > 0) {
            for(int i = 0; i < n; i++) {
                int tmp = arr[arr.length - 1];
                for(int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = tmp;
            }
        } else if (n < 0) {
            for(int i = 0; i < n * (-1); i++) {
                // Left
                int tmp = arr[0];
                for(int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }
        System.out.print("\n     После прокрутки числового ряда: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        int n = 3;
        modifyArray(new int[] {
                4, 3, 6, 16, 5, 2, 0, 2, 4
        }, n);
    }
}
