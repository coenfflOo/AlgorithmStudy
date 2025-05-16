package java_2025.May;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = new String(br.readLine());
        String t = br.readLine();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(t);
        boolean flag = false;
        while(!queue.isEmpty()){
            String str = queue.poll();
            if(str.equals(s)){
                flag = true;
                break;
            } else if (str.length() < s.length()){
                break;
            }

            if (str.charAt(str.length()-1)=='A'){
                queue.add(str.substring(0,str.length()-1));
            } else if (str.charAt(str.length()-1)=='B'){
                StringBuilder sb = new StringBuilder(str.substring(0,str.length()-1));
                str = sb.reverse().toString();
                queue.add(str);
            } else break;
        }

        if(flag){
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
