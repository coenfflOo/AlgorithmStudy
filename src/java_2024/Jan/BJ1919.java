package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fir = br.readLine();
        String sec = br.readLine();

        String[] str1 = fir.split("");
        int count = 0;

        for (int i = 0; i < fir.length(); i++) {
            if (sec.contains(str1[i])){
                sec = sec.replaceFirst(str1[i]," ");
                count++;
            }
        }
        int res = fir.length()+sec.length()-count*2;
        System.out.println(res);
    }
}
