public class HeapSort {

    public void Sort(int arr[]) {
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; --i)
        Heapify(arr, length, i);
        for (int i = length - 1; i > 0; i--)  { 
            Swap(arr, 0, i);
            Heapify(arr, i, 0); 
        } 
    }

    void Heapify(int arr[], int length, int i) {
        int largest = i,
        left = 2 * i + 1,
        right = 2 * i + 2;
        if (left < length && arr[left] > arr[largest]) 
        largest = left; 
        if (right < length && arr[right] > arr[largest]) 
        largest = right; 
        if (largest != i) { 
            Swap(arr, i, largest);
            Heapify(arr, length, largest); 
        } 
    }

    public static void Swap(int arr[], int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
  
        HeapSort ob = new HeapSort(); 
        ob.Sort(arr); 
  
        System.out.println("Sorted array is"); 
        PrintArray(arr); 
    }
}