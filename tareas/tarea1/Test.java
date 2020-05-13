import java.util.*;

public class Test {
    private static final Random random = new Random();
    public static void main(String[] args) {
        int kPosition = (int) (Math.random() * ((max - min) + 1)) + min,
            range = (int) (Math.random() * ((max - min) + 1)) + min + 1;
        int[] arr = new int[range];
        int[] arr2 = new int[range];
        int[][] testArr = new int[40][range];

        for(int i = 0; i < range; ++i)
            arr[i] = random.nextInt();      // filling arr with random numbers
        for (int i = 0; i < 40; ++i) {
            for (int j = 0; j < range; ++j) {
                testArr[i][j] = arr[j];    // 
            }
        }
        for (int i = 0; i < 40; ++i) {
            for (int j = 0; j < range; ++j) {
                arr2[j] = testArr[i][j];
            }
        }
        System.out.println("Range:" + "\t" + min + "/" + max + "\t" + "True range: " + range);
        int i = 1;
        long startTime = System.nanoTime();
        System.out.println("QuickSelect" +  "\t" + "K-th(" + kPosition + ") smallest element in array : " +  
        quickselect.solve(arr, kPosition));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("\t" + "\t" + "Time in ms: " + duration/1000000);
        System.out.println("\t" + "\t" + "Time in ns: " + duration);
        long startTime2 = System.nanoTime();
        System.out.println("MedianOfMedians" +  "\t" + "K-th(" + kPosition + ") smallest element in array : " +  
        mm.solve(arr2, 0, arr2.length - 1 , kPosition));
        mm.solve(arr2, 0, arr2.length - 1 , kPosition);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("\t" + "\t" + "Time in ms: " + duration2/1000000);
        System.out.println("\t" + "\t" + "Time in ns: " + duration2);
    }
} 