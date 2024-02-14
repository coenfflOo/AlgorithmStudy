package java_2024.Jan;
import java.util.*;
import java.io.*;
import java.io.*;
import java.util.*;

public class BJ16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int[][] prefixSum = new int[26][s.length() + 1];

        // 누적 합 배열 초기화
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                prefixSum[j][i + 1] = prefixSum[j][i];
            }
            prefixSum[charIndex][i + 1]++;
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alphabet = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) + 1;

            int alphabetIndex = alphabet - 'a';
            int count = prefixSum[alphabetIndex][end] - prefixSum[alphabetIndex][start];
            bw.write(count + "\n");
        }
        bw.flush();
    }
}
