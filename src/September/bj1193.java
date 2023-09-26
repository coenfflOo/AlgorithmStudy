import java.util.*;
import java.io.*;
public class bj1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int count = 1;
        int sum = 0;
        while (X > count) {
            X -= count;
            sum += count;
            count++;
        }

        int number = count+1;
        int nume = 0;
        int deno = 0;

        if (count%2 == 1){
            nume = number - X;
            deno = X;
        }
        else {
            deno = number - X;
            nume = X;
        }
        bw.write(nume +"/"+ deno);
        bw.flush();
    }
}
// 1/1(1) → 1/2(2) → 2/1(3) → 3/1(4) → 2/2(5) → 1/3(6) →1/4(7)
// → 2/3(8) → 3/2(9) →...→2/4(14)
// 1 1/1
// 2 1/2 2/1
// 3 3/1 2/2 1/3
// 4 1/4 2/3 3/2 4/1
// 5 5/1 4/2 3/3 2/4 1/5
// 1+2+3+4=10