package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][2];
        for(int i=0; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())){
                case 1:
                    arr[i] = new int[]{0,Integer.parseInt(st.nextToken())};
                    break;
                case 2:
                    arr[i] = new int[]{x,Integer.parseInt(st.nextToken())};
                    break;
                case 3:
                    arr[i] = new int[]{Integer.parseInt(st.nextToken()),0};
                    break;
                case 4:
                    arr[i] = new int[]{Integer.parseInt(st.nextToken()),y};
                    break;

            }
        }
        int ci = arr[n][0];
        int cj = arr[n][1];
        int sum = 0;
        for(int i=0; i<n; i++){
            int ni = arr[i][0];
            int nj = arr[i][1];
            if(Math.abs(ci-ni)==x){
//                System.out.println("3");
                sum += Math.min(2*y-(cj+nj), cj+nj)+x;
            } else if(Math.abs(cj-nj)==y){
//                System.out.println("4");
                sum += Math.min(2*x-(ci+ni), ci+ni)+y;
            } else if(ci==ni){
//                System.out.println("1");
                sum += Math.abs(cj-nj);
            } else if(cj==nj){
//                System.out.println("2");
                sum += Math.abs(ci-ni);
            } else {
                int len = Math.abs(ci-ni)+Math.abs(cj-nj);
                sum += Math.min(len, 2*(x+y)-len);
            }
        }
        System.out.println(sum);
    }
}
