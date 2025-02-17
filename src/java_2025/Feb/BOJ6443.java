package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ6443 {
    private static int len;
    private static String[] str;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            str = br.readLine().split("");
            Arrays.sort(str);
            len = str.length;
            visited = new boolean[len];
            StringBuilder sb = new StringBuilder();
            anagram(0, sb);
        }
    }

    private static void anagram(int cnt, StringBuilder sb){
        if (cnt==len){
            System.out.println(sb);
            return;
        }

        StringBuilder visit = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            if (visit.toString().contains(str[i])) continue;
            sb.append(str[i]);
            visited[i] = true;
            visit.append(str[i]);
            anagram(cnt+1, sb);
            sb.deleteCharAt(cnt);
            visited[i] = false;
        }
    }
}
