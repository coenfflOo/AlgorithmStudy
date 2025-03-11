package java_2025.Mar;
import java.util.*;
import java.io.*;
public class BOJ2448 {
    private static int n;
    private static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new String[n][n*2-1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*2-1; j++) {
                map[i][j] = " ";
            }
        }
        printStar(0,n-1, n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*2-1; j++) {
                bw.write(map[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
    }

    private static void printStar(int r, int c, int d) {
        if(d==3){
            map[r][c] = "*";
            map[r+1][c-1] = map[r+1][c+1] ="*";
            for(int i=c-2;i<=c+2;i++){
                map[r+2][i] = "*";
            }
        } else {
            int div = d/2;
            printStar(r,c,div);
            printStar(r+div,c-div,div);
            printStar(r+div,c+div,div);
        }
    }
}
