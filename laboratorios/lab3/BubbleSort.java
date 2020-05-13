public class BubbleSort {
    public static void Sort(int arr[]) { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                    Util.Swap(arr, j, j + 1);
    }
}