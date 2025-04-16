package java_2025.Apr.study;
import java.util.*;
import java.io.*;

import static java.lang.System.exit;

public class BOJ18231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> city = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            city.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            city.get(a).add(b);
            city.get(b).add(a);
        }

        int k = Integer.parseInt(br.readLine());
        boolean[] boom = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int t = Integer.parseInt(st.nextToken());
            boom[t] = true;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            if(boom[i]) {
                boolean flag = true;
                for(int c: city.get(i)) {
                    if (!boom[c]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    ans.add(i);
                }
            }
        }

        boolean[] visited = new boolean[n+1];
        int cnt = 0;
        for (int a: ans){
            if(!visited[a]) {
                visited[a] = true;
                cnt++;
            }

            for(int c: city.get(a)) {
                if(!visited[c]&&boom[c]) {
                    visited[c] = true;
                    cnt++;
                }
            }
        }

        if(ans.isEmpty() || cnt != k) {
            System.out.println(-1);
        } else {
            System.out.println(ans.size());
            for(int a: ans){
                System.out.print(a+" ");
            }
        }

    }
}
