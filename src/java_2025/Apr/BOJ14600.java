package java_2025.Apr;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ14600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int l = (int) Math.pow(2, n);
        int[][] arr = new int[l][l];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = l-Integer.parseInt(st.nextToken());
        arr[y][x] = -1;
        if(n ==1){
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    if (arr[i][j] == -1) {
                        System.out.print(arr[i][j]+" ");
                    } else {
                        System.out.print("1 ");
                    }
                }
                System.out.println();
            }
        } else {
            arr = new int[][]{{1,1,2,2},{1,3,3,2},{4,3,3,5},{4,4,5,5}};
            int temp = arr[y][x];
            arr[y][x] = -1;
            int ni = y;
            int nj = x;
            if((y==3||y==0)&&(x==3||x==0)){
                if(y==3){
                    ni--;
                } else {
                    ni++;
                }
                if(x==3){
                    nj--;
                } else {
                    nj++;
                }
                arr[ni][nj] = temp;
            } else if ((y==1||y==2)&&(x==1||x==2)){
                if(y==2){
                    ni--;
                } else {
                    ni++;
                }
                if(x==2){
                    nj--;
                } else {
                    nj++;
                }
                arr[ni][nj] = temp;
            } else {
                if (y==0){
                    ni++;
                } else if(y==3){
                    ni--;
                }
                if(x==0){
                    nj++;
                } else if(x==3){
                    nj--;
                }
                arr[ni][nj] = temp;
            }

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }

    }
}
