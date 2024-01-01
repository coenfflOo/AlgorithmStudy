package java_2023.October;
import java.util.*;
import java.io.*;
public class bj15652 {
    static int N, M;
    static int[] sequence;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M];

        findSequences(1,0);
        bw.flush();
        bw.close();
    }

    public static void findSequences(int at, int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(sequence[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            sequence[depth] = i;
            findSequences(i,depth + 1);
        }
    }
}
//4 2
//1 1
//1 2
//1 3
//1 4
//2 2
//2 3
//2 4
//3 3
//3 4
//4 4