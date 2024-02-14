package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ2747 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));
    }

    public static int fibo(int n){
        if(n==0)
            return 0;
        else if (n==1) {
            return 1;
        } else {
            return fibo(n-1)+fibo(n-2);
        }
    }
}
