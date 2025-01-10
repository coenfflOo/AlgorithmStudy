package java_2025.Jan;

import java.io.IOException;
import java.util.Scanner;

public class BOJ10994 {
    private static int n;
    private static String[][] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new String[4*n-3][4*n-3];
        drawing(n);
        printStar();
    }

    private static void drawing(int cnt){
        if(cnt==1){
            arr[(4*n-3)/2][(4*n-3)/2] = "*";
            return;
        }

        for(int j=2*(n-cnt); j<(4*n-3)-2*(n-cnt); j++){
            arr[2*(n-cnt)][j] = "*";
            arr[j][2*(n-cnt)] = "*";
            arr[j][(4*n-3)-2*(n-cnt)-1] = "*";
            arr[(4*n-3)-2*(n-cnt)-1][j] = "*";
        }
        drawing(cnt-1);
    }

    private static void printStar(){
        for(String[] str: arr){
            for(String star: str){
                if(star==null)
                    System.out.print(" ");
                else
                    System.out.print(star);
            }
            System.out.println();
        }
    }
}
