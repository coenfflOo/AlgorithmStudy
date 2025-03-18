package java_2025.Mar;
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.System.exit;
public class BOJ16562 {
    private static int n;
    private static int[] friend, cost;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        cost = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<n+1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        friend = new int[n+1];
        set();

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        boolean[] check = new boolean[n+1];
        check[0] = true;
        int sum = 0;
        for (int i=1; i<n+1; i++) {
            int f = find(friend[i]);
            if(check[f]) continue;
            sum += cost[f];
            check[f] = true;
            if(k-sum<0){
                System.out.println("Oh no");
                exit(0);
            }
        }
        System.out.println(sum);
    }

    private static void set(){
        for (int i=0; i<n+1; i++) {
            friend[i] = i;
        }
    }

    private static void union (int a, int b){
        a = find(a);
        b = find(b);

        if(cost[a]<cost[b]){
            friend[b] = a;
        } else friend[a] = b;
    }

    private static int find(int a){
        if(friend[a]== a) return a;
        else return friend[a] = find(friend[a]);
    }
}
