package September;
import java.util.*;
import java.io.*;
public class bj4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        StringBuilder sb = new StringBuilder();

        while (!(s = br.readLine()).equals("0")) {
            long num = Long.parseLong(s);
            long count = findNextPrime(num);
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    private static long findNextPrime(long num) {
        if (num == 1) return 1;

        long count = 0;
        boolean[] check = new boolean[(int) (num*2+1)];
        for (int i = 2; i <= num*2; i++) {
            if (!check[i] && i > num)
                count++;
            for (int j = i*2; j <= num*2; j += i) {
                check[j] = true;
            }
        }
        return count;
    }
}
