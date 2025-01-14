package java_2025.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ15665 {
    private static int n,m;
    private static int[] number;
    private static int[] arr;
    private static HashSet<Integer> set;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        arr = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        for(int i=0; i<set.size(); i++){
            arr[i] = iter.next();
        }
        Arrays.sort(arr);

        number = new int[m];
        comb(0);
    }

    private static void comb(int cnt){
        if(cnt==m){
            sb = new StringBuilder();
            for(int num: number){
                sb.append(num).append(" ");
            }
            System.out.println(sb);
            return;
        }

        int past = 0;
        for(int i = 0; i<arr.length; i++){
            if(past != arr[i]){
                past = arr[i];
                number[cnt] = arr[i];
                comb(cnt+1);
            }
        }
    }
}
