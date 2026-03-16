package java_2026.Mar;
import static java.lang.System.exit;

import java.util.*;
import java.io.*;
public class BOJ14916 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = n/5;
        n %= 5;
        while (n%2==1 && cnt>0){
            cnt--;
            n += 5;
        }
        if(n%2==1 && cnt==0){
            System.out.println("-1");
        } else {
            cnt += n/2;
            System.out.println(cnt);
        }
    }
}
