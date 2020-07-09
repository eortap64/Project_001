package Lesson_002;
public class Task_002 {
    public static void main(String[] args)
    {
        int[] arr = new int[8];
        int j = 0;
        int m1 = arr.length;
//       for(int i = 0; i < m1; i++)
//       {System.out.print(arr[i]+" ");}
//        System.out.println(" ");
        for(int i = 0; i < m1; i++, j = j+3)
        {
            arr[i] = j;
        }
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
