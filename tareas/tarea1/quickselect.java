public class quickselect {
    public static int solve(int[] arr, int k) {
        int start = 0, 
            end = arr.length - 1,
            index = k - 1;
        while (start < end) {
            int pivot = partion(arr, start, end);
            if (pivot < index) start = pivot + 1; 
            else if (pivot > index) end = pivot - 1;
            else return arr[pivot];
        }
        return arr[start];
    }
    
    private static int partion(int[] arr, int start, int end) {
        int pivot = start;
        while (start <= end) {
            while (start <= end && arr[start] <= arr[pivot]) start++;
            while (start <= end && arr[end] > arr[pivot]) end--;
            if (start > end) break;
            util.swap(arr, start, end);
        }
        util.swap(arr, end, pivot);
        return end;
    }
}