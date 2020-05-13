import java.util.*;

public class Test {
    private static final Random random = new Random();
    public static void main(String[] args) {
        int arrSize = 10000,
            kPosition = (int) (Math.random() * arrSize + 1);
        int[] arr = new int[arrSize];
        int[] arr2 = new int[arrSize];
        for(int i = 0; i < arrSize; ++i) {
            arr[i] = random.nextInt();
            arr2[i] = arr[i];
        }
        System.out.println("Array size:" + "\t" + arrSize);

        long startTime = System.nanoTime();
        System.out.println("QuickSelect" +  "\t" + "K-th(" + kPosition + ") smallest element in array : " +  
        quickselect.solve(arr, kPosition));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("\t" + "\t" + "Time in ms: " + duration/1000000);
        System.out.println("\t" + "\t" + "Time in ns: " + duration);

        long startTime2 = System.nanoTime();
        System.out.println("MedianOfMedians" +  "\t" + "K-th(" + kPosition + ") smallest element in array : " +  
        mm.solve(arr2, 0, arrSize - 1 , kPosition));
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("\t" + "\t" + "Time in ms: " + duration2/1000000);
        System.out.println("\t" + "\t" + "Time in ns: " + duration2);
    }
} 