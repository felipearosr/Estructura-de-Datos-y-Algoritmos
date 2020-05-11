import java.io.*;
import java.util.*;

public class Solution {

   static void revString(String str) {
       char[] result = str.toCharArray();
       for (int i = str.length() - 1; i >= 0; i--) {
           System.out.print(result[i]);
       }
   }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        revString(str);
    }
}