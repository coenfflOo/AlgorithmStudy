package java_2024.Mar;
import java.util.*;
import java.io.*;
public class BOJ15663 {
    static int n,m;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        visited = new boolean[n];
        result = new int[m];
        permArr(0);
    }

    private static void permArr(int idx) {
        if (idx == m){
            for(int i = 0; i<m; i++)
                System.out.print(result[i]+" ");
            System.out.println();
            return;
        }

        int before = 0;
        for(int i = 0; i<n; i++){
            if(visited[i])
                continue;

            if(before != arr[i]){
                visited[i] = true;
                result[idx] = arr[i];
                before = arr[i];
                permArr(idx+1);
                visited[i] = false;
            }
        }
    }
}
