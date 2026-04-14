package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] liquids = new int[N];
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = N-1;
        int ans = Integer.MAX_VALUE;
        while (left < right) {
            if (Math.abs(ans)>Math.abs(liquids[left] + liquids[right])) {
                ans = liquids[left] + liquids[right];
            }
            if (Math.abs(liquids[left]) > Math.abs(liquids[right])) {
                left++;
            } else if (Math.abs(liquids[left]) < Math.abs(liquids[right])) {
                right--;
            } else {
                if (liquids[left] + liquids[right]==0) {
                    System.out.println("0");
                    return;
                }
                left++;
            }
        }
        System.out.println(ans);
    }
}
