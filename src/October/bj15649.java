package October;
import java.util.*;
import java.io.*;
public class bj15649 {
    static int N, M;
    static int[] sequence;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M];
        used = new boolean[N];

        findSequences(0);
    }

    public static void findSequences(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i - 1]) {
                sequence[depth] = i;
                used[i - 1] = true;
                findSequences(depth + 1);
                used[i - 1] = false;
            }
        }
    }
}
//4 2

//1 2
//1 3
//1 4
//2 1
//2 3
//2 4
//3 1
//3 2
//3 4
//4 1
//4 2
//4 3
