import java.util.*;
import java.io.*;

public class Main {
    static int R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            R = 1;
            sb.append(isPalindrome(str)).append(" ").append(R).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    public static int recursion(String s, int l, int r){
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else {
            R++;
            return recursion(s, l + 1, r - 1);
        }
    }
}