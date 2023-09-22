import java.util.*;
import java.io.*;

public class bj11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while(q.size() > 1) {

            for(int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }

            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append('>');
        bw.write(sb.toString());
        bw.flush();
    }
}
