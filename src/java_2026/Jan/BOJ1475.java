package java_2026.Jan;
import java.util.*;
import java.io.*;
public class BOJ1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        int[] arr = new int[10];
        int cnt = 0;
        for (String s : str) {
            int num = Integer.parseInt(s);
            if (num == 6 && arr[6] > arr[9]) {
                arr[9]++;
                cnt = Math.max(cnt, arr[9]);
            } else if (num == 9 && arr[6] < arr[9]) {
                arr[6]++;
                cnt = Math.max(cnt, arr[6]);
            } else {
                arr[num]++;
                cnt = Math.max(cnt, arr[num]);
            }
        }

        System.out.println(cnt);
    }
}
