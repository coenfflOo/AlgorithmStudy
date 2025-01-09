package java_2025.Jan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
    private static int k;
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        sb = new StringBuilder();
        while(!(str = br.readLine()).equals("0")){
            StringTokenizer st = new StringTokenizer(str);
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            visited = new boolean[k];
            for(int i=0; i<k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            findNumber(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void findNumber(int start, int cnt){
        if(cnt == 6){
            for(int i=0; i<k; i++){
                if(visited[i]){
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        if(cnt>6||start>=k)
            return;

        for(int i = start; i<k; i++){
            if(!visited[i]){
                visited[i] = true;
                findNumber(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }
}
