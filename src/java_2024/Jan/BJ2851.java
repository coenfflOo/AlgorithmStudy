package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 100) {
                return;
            }
            sum += num;
            if (sum >= 100) {
                if (sum - 100 <= 100 - (sum - num)) {
                    sb.append(sum);
                } else {
                    sb.append(sum - num);
                }
                break;
            }
        }
        if (sum < 100) {
            sb.append(sum);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
