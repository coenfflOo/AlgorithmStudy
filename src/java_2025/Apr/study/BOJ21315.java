package java_2025.Apr.study;
import java.util.*;
import java.io.*;

public class BOJ21315 {
    private static int n;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] card = new int[n];
        int[] current = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            current[i] = i+1;
        }

        for (int k1 = 1; Math.pow(2,k1) < n; k1++) {
            for (int k2 = 1; Math.pow(2,k2) < n; k2++) {
                arr = current.clone();
                cardChange(k1);
                cardChange(k2);

                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    if (arr[i] != card[i]) {
                        flag = true;
                    }
                }

                if(!flag) {
                    System.out.println(k1+" "+k2);
                    return;
                }
            }
        }
    }

    private static void cardChange(int k) {
        int[] cur = new int[n];
        int index = 0;
        boolean[] visited = new boolean[n+1];
        for (int i = 0; i <= k; i++) {
            for(int j = (int) Math.min(n-Math.pow(2,i), n-1); j < n; j++) {
                if(!visited[arr[j]]) {
                    visited[arr[j]] = true;
                    cur[index++] = arr[j];
                }
            }
        }
        for (int i = 0; i < n-Math.pow(2,k); i++) {
            cur[index++] = arr[i];
        }
        arr = cur;
    }
}
