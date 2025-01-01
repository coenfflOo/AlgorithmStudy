package java_2024.June;
import java.util.*;
import java.io.*;

public class BOJ9466 {
    static int n, k, cur, cnt;
    static int[] arr,index;
    static boolean[] visited;
//    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < t; test_case++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            index = new int[n];
            visited = new boolean[n];
            cnt = n;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i]=Integer.parseInt(st.nextToken());
                if (arr[i]==i+1){
                    visited[i]=true;
                    cnt--;
                }
            }

            for (int i = 0; i < n; i++) {
                int idx = i;
                if (!visited[i]){
                    k = 0;
                    while(true){
                        index[k++]=idx;
                        visited[idx]=true;
                        cur=0;
                         if(!visited[arr[idx]-1]) {
                            idx = arr[idx]-1;
                        } else if(check(arr[idx]-1)) {
                             cnt -= (k-cur);
                             break;
                         } else break;
                    }
//                    System.out.println(cnt);
//                    System.out.println(Arrays.toString(visited));
                }
            }

            bw.write(String.valueOf(cnt));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static boolean check(int idx) {
//        System.out.println(Arrays.toString(index));
//        System.out.println("s");
        for (int i = 0; i < k; i++) {
            if (index[i]==idx) {
                cur=i;
                return true;
            }
            index[i]=0;
        }
        return false;
    }
}
