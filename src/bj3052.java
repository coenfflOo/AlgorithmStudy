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

//        Set<Integer> arrS = new HashSet<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        // int 배열을 Stream을 이용해 Set으로 변환
        Set<Integer> arrSet = Arrays.stream(arr)
                .boxed() // int를 Integer로 박싱(boxing)
                .collect(Collectors.toSet());

        bw.write(String.valueOf(arrSet.size()));
        bw.flush();
    }
}
