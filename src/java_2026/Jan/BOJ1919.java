package java_2026.Jan;
import java.util.*;
import java.io.*;

public class BOJ1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] letters = new int[26];
        String str1 = br.readLine();
        String str2 = br.readLine();
        for (int i = 0; i < str1.length(); i++) {
            letters[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            letters[str2.charAt(i) - 'a']--;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                if (letters[i] < 0) sum += letters[i]*-1;
                else sum += letters[i];
            }
        }
        System.out.println(sum);
    }
}
