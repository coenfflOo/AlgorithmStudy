package java_2025.Apr.study;
import java.util.*;
import java.io.*;
public class BOJ2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        StringBuffer sb = new StringBuffer(str[0]);
        int a = Integer.parseInt(sb.reverse().toString());
        sb = new StringBuffer(str[1]);
        int b = Integer.parseInt(sb.reverse().toString());
        System.out.println(Math.max(a,b));
    }
}
