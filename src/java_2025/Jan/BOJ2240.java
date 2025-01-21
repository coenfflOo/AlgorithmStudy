package java_2025.Jan;
import java.util.*;
import java.io.*;
public class BOJ2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int want = Integer.parseInt(st.nextToken());
        int[] drop = new int[time+1];
        for (int i = 1; i <= time; i++) {
            drop[i] = Integer.parseInt(br.readLine());
        }

//        System.out.println(Arrays.toString(drop));
//        System.out.println("========================");
        int[][] plum = new int[want+1][time+1];
        for (int j = 1; j <= time; j++) {
            for (int i = 0; i < want+1; i++) {
                int prev = Math.max(i - 1, 0);
                if(drop[j]-1==i%2){ // 받을수 있음
                    plum[i][j] = Math.max(plum[i][j-1]+1, plum[prev][j-1]+1);
                } else { // 못받음
                    plum[i][j] = Math.max(plum[i][j-1], plum[prev][j-1]);
                }
            }
        }

//        for(int[] num: plum){
//            System.out.println(Arrays.toString(num));
//        }

        int max = 0;
        for (int i = 0; i < want+1; i++) {
            if(max<plum[i][time])
                max=plum[i][time];
        }
        System.out.println(max);
    }
}
