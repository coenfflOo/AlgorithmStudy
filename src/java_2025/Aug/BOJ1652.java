package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] str = new String[n][n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine().split("");
        }

        int garo = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if(str[i][j].equals(".")){
                    sum++;
                } else {
                    if (sum >= 2) garo++;
                    sum = 0;
                }
            }
            if (sum >= 2) garo++;
        }

        int sero = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if(str[j][i].equals(".")){
                    sum++;
                } else {
                    if (sum >= 2) sero++;
                    sum = 0;
                }
            }
            if (sum >= 2) sero++;
        }
        System.out.println(garo+" "+sero);
    }
}
