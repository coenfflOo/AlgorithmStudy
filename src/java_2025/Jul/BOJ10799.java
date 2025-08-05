package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        Stack<String> pipe = new Stack<>();
        int cnt = 0;
        int cur = 0;
        String prev = null;
        for(String str : s){
            if(str.equals("(")) {
                pipe.push(str);
                cur++;
            }
            else if(str.equals(")")) {
                cur--;
                if(!pipe.isEmpty() && prev.equals("(")) {
                    pipe.pop();
                    cnt += cur;
                } else {
//                    System.out.print("here ");
                    pipe.pop();
                    cnt += 1;
                }
            }
//            System.out.println(cnt);
            prev = str;
        }
        System.out.println(cnt);
    }
}
