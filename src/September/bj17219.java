package September;
import java.util.*;
import java.io.*;

public class bj17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        Map<String, String> webMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String address = input[0];
            String password = input[1];
            webMap.put(address, password);
        }

        for (int i = 0; i < M; i++) {
            String findWeb = br.readLine();
            String password = webMap.get(findWeb);
            sb.append(password).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
