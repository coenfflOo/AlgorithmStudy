import java.util.*;
import java.io.*;
public class bj2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] coin = {25, 10, 5, 1};
        for (int i = 0; i < T; i++) {
            int money  = Integer.parseInt(br.readLine());
            for (int j = 0; j < coin.length; j++) {
                bw.write(money/coin[j]+" ");
                money %= coin[j];
            }
            bw.write("\n");
        }
        bw.flush();
    }

}
