package September;
import java.util.*;
import java.io.*;
public class bj24313 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A1 = Integer.parseInt(st.nextToken());
        int A2 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int f = A1*n+A2;
        int g = c*n;

        int result = (f <= g)&&(c >= A1) ? 1:0;
        // a1n + a0 ≤ cn0
        // c ≤ a1
        System.out.println(result);
    }
}
