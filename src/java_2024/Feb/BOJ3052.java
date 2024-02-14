package java_2024.Feb;
import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class BOJ3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num % 42;
        }

        Set<Integer> res = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        bw.write(String.valueOf(res.size()));
        bw.flush();
    }
}
