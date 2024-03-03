package java_2024.Feb;
import java.util.*;
import java.io.*;
public class BOJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        // 3킬로그램 봉지와 5킬로그램 봉지
        // 최대한 적게
        // 정확하게 N킬로그램을 만들 수 없다면 -1
        while (n>0){
            if (n%5==0){
                cnt += n/5;
                n %= 5;
            }else{
                cnt++;
                n -= 3;
            }
        }

        if (n<0)
            cnt = -1;
        System.out.println(cnt);
    }
}
