import java.util.*;
import java.io.*;
public class bj2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = croa(br.readLine());
        int count = str.length();
        bw.write(String.valueOf(count));
        bw.flush();
    }

    private static String croa(String s){
        String[] C = {"c=","c-","d-","dz=","lj","nj","s=","z="};
        for (int i = 0; i < C.length; i++) {
            if (s.contains(C[i])) {
                //replace 함수 사용 대박..
                s = s.replace(C[i], "A");
            }
        }
        return s;
    }
}