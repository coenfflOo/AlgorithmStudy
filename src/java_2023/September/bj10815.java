package java_2023.September;
import java.util.*;
import java.io.*;
public class bj10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st2.nextToken());
            if (numbers.contains(num))
                result.append(1).append(" ");
            else
                result.append(0).append(" ");
        }

        bw.write(result.toString());
        bw.close();
    }
}
