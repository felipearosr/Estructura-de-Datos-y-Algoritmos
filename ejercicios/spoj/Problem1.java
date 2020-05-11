import java.io.*;
import java.util.*;

//  Life,_the_Universe,_and_Everything

public class Problem1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws java.lang.Exception {
        int n = 0;
        while(true) {
            n = scanner.nextInt();
            if (n == 42) {
                break;
            }
            else {
                System.out.println(n);
            }
        }
    }
}