import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        String answer = cal(price, N)? "Yes": "No";
        System.out.println(answer);
    }
    public static boolean cal(int price, int N) throws IOException {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sum += a*b;
        }

        if (sum == price)
            return true;
        else
            return false;
    }
}