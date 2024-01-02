package java_2024.Jan;
import java.util.*;
import java.io.*;

public class BJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(A);
        Collections.reverse(A);
        Collections.sort(B);
        int sum = 0;
        for (int j = 0; j < N; j++) {
            sum += A.get(j) * B.get(j);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
