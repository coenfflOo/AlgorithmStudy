package java_2025.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15664 {
    private static int n,m;
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb;
    private static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        set = new HashSet<>();
        perm(0,0, 0);
    }

    private static void perm(int target, int select, int pre){
        if(select == m){
            sb = new StringBuilder();
            for(int i=0; i<n; i++){
                if(visited[i]){
                    sb.append(arr[i]).append(" ");
                }
            }
            System.out.println(sb.toString());
            return;
        }


        for (int i = target; i < n; i++) {
            if (i > target && arr[i] == arr[i - 1]) continue;
            visited[i] = true;
            perm(i + 1, select + 1, arr[i]);
            visited[i] = false;
        }
    }
}
