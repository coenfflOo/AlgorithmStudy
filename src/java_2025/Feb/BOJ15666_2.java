package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ15666_2 {
    private static int n,m;
    private static int[] arr;
    private static int[] answer;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            set.add(number);
        }

        n = set.size();
        arr = new int[n];
        int a = 0;
        for(int num: set){
            arr[a++] = num;
        }

        Arrays.sort(arr);
        sb = new StringBuilder();
        answer = new int[m];
        perm(0,0);
        System.out.println(sb);
    }

    private static void perm(int cnt,int start){
        if(cnt==m){
            for(int num: answer){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            answer[cnt] = arr[i];
            perm(cnt+1,i);
        }
    }
}