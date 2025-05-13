package java_2025.May;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] height = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        int[] max_left = new int[w];
        int[] max_right = new int[w];

        max_left[0] = height[0];
        for (int i = 1; i < w; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i]);
        }

        max_right[w - 1] = height[w - 1];
        for (int i = w - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i]);
        }

        int total = 0;
        for (int i = 0; i < w; i++) {
            int water = Math.min(max_left[i], max_right[i])-height[i];
            if (water > 0) {
                total += water;
            }
        }
        System.out.println(total);
    }
}
