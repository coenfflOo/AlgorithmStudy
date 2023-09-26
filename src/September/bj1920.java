import java.util.*;
import java.io.*;
public class bj1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String N = br.readLine();
//        String A = br.readLine();
//
//        int M = Integer.parseInt(br.readLine());
//        String[] B = br.readLine().split(" ");
//        for (int i = 0; i < M; i++) {
//            if (A.toString().contains(B[i]))
//                bw.write("1\n");
//            else
//                bw.write("0\n");
//        }
//        contains()는 리스트의 크기에 비례하는 O(n)의 시간복잡도를 갖습니다. 따라서 입력의 최대치인 N = M = 100,000인 경우에 반복문을 통해 contains()로 존재 여부를 확인하면 최대 100억번의 연산이 필요하기 때문에 시간초과가 발생할 수밖에 없습니다.

        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(A[i]);
        }

        int M = Integer.parseInt(br.readLine());
        String[] B = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            if (set.contains(B[i]))
                bw.write("1\n");
            else
                bw.write("0\n");
        }
        bw.flush();
    }
}