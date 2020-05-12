public class InsertSort {
    
    void sort(int arr[]) {
        for (int i = 1; i < arr.length; ++i) { 
            int key = arr[i], 
                j = i - 1; 
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    }
    public static void main(String args[]) { 
        int arr[] = { 12, 11, 13, 5, 6 }; 
      
        InsertSort ob = new InsertSort(); 
        ob.sort(arr); 
      
        Util.PrintArray(arr); 
    } 
}
