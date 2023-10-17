package October;
import java.util.*;
import java.io.*;
public class bj1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(br.readLine());
            if (x == 0 && !minHeap.isEmpty()){
                sb.append(Math.toIntExact(minHeap.poll())).append("\n");
            } else if (x == 0){
                sb.append("0").append("\n");
            } else {
                minHeap.add(x);
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
