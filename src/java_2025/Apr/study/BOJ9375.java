package java_2025.Apr.study;
import java.io.*;
import java.util.*;

public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] st = br.readLine().split(" ");
                map.put(st[1], map.getOrDefault(st[1], 0) + 1);
            }
            int res = 1;
            for (int num : map.values()) {
                res *= (num+1);
            }
            System.out.println(res-1);
        }
    }
}
