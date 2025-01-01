package java_2024.June;
import java.util.*;
import java.io.*;
public class BOJ15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] pay = new int[n+2];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            if (i!=0){
                pay[i]=Math.max(pay[i],pay[i-1]);
            }
            if (i+day<n+2) {
                pay[i + day] = Math.max(pay[i + day], pay[i] + money);
            }
        }
        pay[n+1]=Math.max(pay[n],pay[n+1]);
        System.out.println(pay[n+1]);
    }
}
