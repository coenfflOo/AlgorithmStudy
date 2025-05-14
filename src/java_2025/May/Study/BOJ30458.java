package java_2025.May.Study;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ30458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        int[] alphas = new int[26];
        for (int i = 0; i < n/2; i++) {
            alphas[str[i] - 'a']++;
        }
        for (int i = (n+1)/2; i < n; i++) {
            alphas[str[i] - 'a']--;
        }

        for(int a: alphas) {
            if (a % 2 == 1){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
