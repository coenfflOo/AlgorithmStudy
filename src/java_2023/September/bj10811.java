import java.util.*;
import java.io.*;
public class bj10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N];
        for (int i = 0; i < basket.length; i++) {
            basket[i] = (i+1);
        }
        System.out.println(Arrays.toString(basket));

        for (int k = 0; k < M; k++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken())-1;
            int b = Integer.parseInt(st2.nextToken())-1;

            for (int j = a; j <= b; j++) {
                int newNum = b--;

                int tmp = basket[j];
                basket[j] = basket[newNum];
                basket[newNum] = tmp;
            }
        }

        for (int bas : basket) {
            bw.write(bas+" ");
        }
        bw.flush();
    }
}
