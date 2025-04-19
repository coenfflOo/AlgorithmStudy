package java_2025.Apr;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ10453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            if (str1.equals(str2)) sb.append("0");
            else if(str1.length() != str2.length())sb.append("-1");
            else {
                Queue<Integer> aq = new LinkedList<>();
                Queue<Integer> bq = new LinkedList<>();
                for (int j = 0; j < str1.length(); j++) {
                    if (str1.charAt(j) != str2.charAt(j)){
                        if(str1.charAt(j) == 'a') aq.add(j);
                        else if(str2.charAt(j) == 'a') bq.add(j);
                    }
                }
                int sum = 0;
                while (!aq.isEmpty() && !bq.isEmpty()) {
                    int a = aq.poll();
                    int b = bq.poll();
                    sum += Math.abs(a - b);
                }
                sb.append(sum);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
