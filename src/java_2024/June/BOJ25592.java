package java_2024.June;
import java.util.*;
import java.io.*;
public class BOJ25592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        while(n>=cnt){
            n -= cnt;
            cnt++;
        }
        if (cnt%2==1){
            System.out.println(cnt-n);
        } else {
            System.out.println(0);
        }
    }
}
