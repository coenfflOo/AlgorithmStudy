package java_2023.October;
import java.util.*;
import java.io.*;

public class bj9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> fashion = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String[] s = br.readLine().split(" ");
                String type = s[1];

                // 의상 종류별로 개수를 센다
                fashion.put(type, fashion.getOrDefault(type, 0) + 1);
            }

            int result = 1;

            // 각 의상 종류별로 (의상 개수 + 1)을 곱하여 조합 계산
            for (int num : fashion.values()) {
                result *= (num + 1);
            }

            // 모든 의상을 입지 않은 경우를 빼준다
            result -= 1;

            sb.append(result + "\n");
        }
        System.out.print(sb);
    }
}
