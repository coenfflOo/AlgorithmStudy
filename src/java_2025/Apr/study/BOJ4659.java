package java_2025.Apr.study;
import java.util.*;
import java.io.*;
public class BOJ4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s=br.readLine()).equals("end")){
            boolean flag = false;
            int cnt = 0;
            char prev = ' ';
            String m = "aeiou";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (m.contains(String.valueOf(c))) flag = true;
                if (m.contains(String.valueOf(c)) != m.contains(String.valueOf(prev))) cnt = 1;
                else cnt++;
                if (cnt>2 || (prev==c && (c != 'e' && c != 'o'))){
                    flag = false;
                    break;
                }
                prev = c;
            }
            if (!flag){
                System.out.println("<"+s+"> is not acceptable.");
            } else {
                System.out.println("<"+s+"> is acceptable.");
            }
        }
    }
}
