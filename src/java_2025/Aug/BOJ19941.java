package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] ph = br.readLine().split("");
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (ph[i].equals("P")){
                for (int j = Math.max(0,i-k); j <= Math.min(i+k, n-1); j++) {
                    if (ph[j].equals("H") && !visited[j]){
                        visited[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
