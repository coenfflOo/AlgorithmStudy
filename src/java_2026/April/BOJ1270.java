package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1270 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int ti = Integer.parseInt(st.nextToken());
            Map<Long, Long> map = new HashMap<>();
            long ans = Long.MAX_VALUE;
            for (int i = 0; i < ti; i++) {
                long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num, (long)0) + 1);
                if (map.get(num) > (ti/2)) {
                    ans = num;
                }
            }

            if (ans == Long.MAX_VALUE) {
                sb.append("SYJKGW");
            } else {
                sb.append(ans);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
