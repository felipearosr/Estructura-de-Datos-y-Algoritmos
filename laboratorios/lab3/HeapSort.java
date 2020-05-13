public class HeapSort {

    public static void Sort(int arr[]) {
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; --i)
            Heapify(arr, length, i);
        for (int i = length - 1; i > 0; i--)  { 
            Util.Swap(arr, 0, i);
            Heapify(arr, i, 0); 
        } 
    }

    public static void Heapify(int arr[], int length, int i) {
        int largest = i,
            left = 2 * i + 1,
            right = 2 * i + 2;
        if (left < length && arr[left] > arr[largest]) 
            largest = left; 
        if (right < length && arr[right] > arr[largest]) 
            largest = right; 
        if (largest != i) { 
            Util.Swap(arr, i, largest);
            Heapify(arr, length, largest); 
        }
    }
}