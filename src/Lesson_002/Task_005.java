package Lesson_002;
public class Task_005 {
    public static void main(String[] args) {
        int[] mass1 = new int[] {34, 16, 24, 2, 13, 147, 72, 112, -12, -29};
        int max = getMax(mass1);
        System.out.println("max: "+max);
        int min = getMin(mass1);
        System.out.println("min: "+min);
    }
    public static int getMax(int[] inputArray) {
        int t1max = inputArray[0];
        for(int i = 1;i < inputArray.length;i++) {
            if(inputArray[i] > t1max) {
            t1max = inputArray[i];
        }
        }
        return t1max;
    }
    public static int getMin(int[] inputArray) {
        int t1min = inputArray[0];
        for(int i=1; i<inputArray.length; i++) {
            if(inputArray[i] < t1min){
                t1min = inputArray[i];
            }
        }
        return t1min;
    }
}
