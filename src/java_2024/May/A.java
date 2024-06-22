package java_2024.May;
import java.util.*;
import java.io.*;
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum = 0;
        int cnt=0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum+= Integer.parseInt(st.nextToken());
            if(sum>=m)
                cnt++;
            else if (sum<0) {
                sum=0;
            }
        }
        System.out.println(cnt);
    }
}
