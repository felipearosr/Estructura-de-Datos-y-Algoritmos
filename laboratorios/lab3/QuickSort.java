public class QuickSort {
    
    void Sort(int arr[], int low, int high) { 
        if (low < high) {
            int pi = partition(arr, low, high); 
            Sort(arr, low, pi - 1); 
            Sort(arr, pi + 1, high); 
        } 
    } 
    
    int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1);
        for (int j = low; j < high; ++j) {
            if (arr[j] < pivot) {
                Util.Swap(arr, ++i, j);
            } 
        }
        Util.Swap(arr, i + 1, high);
        return i + 1;  
    } 
  
    public static void main(String args[]) { 
        int arr[] = {10, 7, 8, 9, 1, 5},
            n = arr.length; 
      
        QuickSort ob = new QuickSort(); 
        ob.Sort(arr, 0, n-1); 
      
        System.out.println("sorted array"); 
        Util.PrintArray(arr); 
    }
}