package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 1; i < str.length()-1; i++) {
            for (int j = i+1; j < str.length(); j++) {
                StringBuilder first = new StringBuilder(str.substring(0,i)).reverse();
                StringBuilder second = new StringBuilder(str.substring(i,j)).reverse();
                StringBuilder third = new StringBuilder(str.substring(j,str.length())).reverse();
                String ans = first.toString() + second.toString() + third.toString();
                pq.add(ans);
            }
        }
        System.out.println(pq.poll());
    }
}
