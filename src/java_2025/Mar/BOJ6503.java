package java_2025.Mar;
import java.util.*;
import java.lang.*;
import java.io.*;
public class BOJ6503 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s = br.readLine()).equals("0")){
            int m = Integer.parseInt(s);
            char[] characters = br.readLine().toCharArray();

            int left = 0, right = 0, ans = 0;
            int[] use = new int[128];
            int total = 0;

            while(right<characters.length){
                char c = characters[right];
                // 새로운 문자면 total 증가
                if (use[c] == 0) total++;
                use[c]++;

                // 서로 다른 문자가 m개 초과되면 left 이동
                while (total > m) {
                    char leftChar = characters[left];
                    use[leftChar]--;
                    if (use[leftChar] == 0) total--;  // 문자 개수가 0이 되면 total 감소
                    left++;
                }

                ans = Math.max(ans, right - left + 1);
                right++;
            }
            System.out.println(ans);
        }
    }
}
