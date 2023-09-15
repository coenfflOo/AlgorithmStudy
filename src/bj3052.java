import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class bj3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num % 42;
        }

        Set<Integer> arrS = new HashSet<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        bw.write(String.valueOf(arrS.size()));
        bw.flush();
    }
}
