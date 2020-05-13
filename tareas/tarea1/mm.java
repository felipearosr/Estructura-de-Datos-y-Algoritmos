import java.util.Arrays;

public class mm {
    public static int partition(int[] list, int start, int end, int val) {
        int i;
        for (i = start; i < end; i++)
            if (list[i] == val)
                break;
        util.swap(list, i, end);
        int pivotValue = list[end];
        int storeIndex = start;
        for (i = start; i <= end; i++) {
            if (list[i] < pivotValue) {
                util.swap(list, storeIndex, i);
                storeIndex++;
            }
        }
        util.swap(list, end, storeIndex);
        return storeIndex;
    }
    static int findMedian(int arr[], int start, int length) {
        Arrays.sort(arr, start, start + length);
        return arr[start + length / 2];
    }
    static int solve(int arr[], int start, int end, int k) {
        if (k > 0 && k <= end - start + 1) {
            int n = end - start + 1, i;
            int median[] = new int[(n + 4) / 5];
            for (i = 0; i < n / 5; i++) {
                median[i] = findMedian(arr, start + i * 5, 5);
            }
            if (i * 5 < n) {
                median[i] = findMedian(arr, start + i * 5, n % 5);
                i++;
            }
            int medOfMed = (i == 1) ? median[i - 1]: solve(median, 0, i - 1, i / 2);

            int pos = partition(arr, start,end, medOfMed);
            if (pos - start == k - 1) {
               return arr[pos];
            }
            if (pos - start > k - 1) {
               return solve(arr, start, pos - 1, k);
            }
           return solve(arr, pos + 1, end , k - pos + start - 1);
        }
        return Integer.MAX_VALUE;
    }
}