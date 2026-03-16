package java_2026.Mar;
import java.util.*;
import java.io.*;
public class BOJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = N/5;
        N %= 5;
        while (N%3 != 0 && cnt != 0) {
            cnt--;
            N+=5;
        }
        if (N%3 != 0){
            System.out.println("-1");
        } else {
            cnt += N/3;
            System.out.println(cnt);
        }
    }
}
