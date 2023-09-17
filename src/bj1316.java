import java.util.*;
import java.io.*;
public class bj1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count= 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (!check(s))
                count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }

    private static boolean check(String s){
        boolean checkNum = false;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+2; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (s.charAt(i) != s.charAt(j-1)){
                        checkNum = true;
                        break;
                    }
                }
            }
        }
        return checkNum;
    }
}
