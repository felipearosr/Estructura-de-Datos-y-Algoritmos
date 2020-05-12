public class MergeSort {
    void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1,
            n2 = r - m,
            L[] = new int [n1],
            R[] = new int [n2]; 
  
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
        int i = 0,
            j = 0,
            k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j])
                arr[k] = L[i++]; 
            else
                arr[k] = R[j++];
            k++; 
        } 
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    void sort(int arr[], int l, int r) { 
        if (l < r) {
            int m = (l + r) / 2; 
            sort(arr, l, m); 
            sort(arr , m+1, r);
            merge(arr, l, m, r); 
        } 
    }
    public static void main(String args[]) { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
      
        System.out.println("Given Array"); 
        Util.PrintArray(arr); 
      
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
      
        System.out.println("\nSorted array"); 
        Util.PrintArray(arr); 
    } 
}