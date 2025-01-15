package java_2025.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ15666 {
    private static int n,m;
    private static HashSet<Integer> set;
    private static int[] arr;
    private static int[] number;
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
        Iterator<Integer> itr = set.iterator();
        int i = 0;
        for (Iterator<Integer> it = itr; it.hasNext(); ) {
            int num = it.next();
            arr[i++] = num;
        }
        Arrays.sort(arr);

        number = new int[m];
        sb = new StringBuilder();
        comb(0, 0);
        System.out.println(sb);
    }

    private static void comb(int start, int cnt){
        if(cnt == m){
            for(int num: number){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<arr.length; i++){
            number[cnt] = arr[i];
            comb(i, cnt+1);
        }
    }
}
