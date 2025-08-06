package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ13023 {
    static List<Integer>[] list;
    static boolean[] visited;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i,0);
            if (flag) break;
        }

        System.out.println(flag?"1":"0");
    }

    private static void dfs(int cur, int depth) {
        if (depth == 4){
            flag = true;
            return;
        }
        visited[cur] = true;
        for(int next : list[cur]){
            if (!visited[next]){
                dfs(next,depth+1);
                if (flag) return;
            }
        }
        visited[cur] = false;
    }
}
