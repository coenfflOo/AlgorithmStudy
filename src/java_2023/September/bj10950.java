import java.io.*;
import java.util.StringTokenizer;

public class bj10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        cal(T);
    }

    public static void cal(int T) throws IOException {
        int[] arr = new int[T];
        for (int i = 0; i < T; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[i] = A+B;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int num: arr ) {
            bw.write(num +"\n");
        }

        for (int i = 0; i < T; i++) {
            bw.write("Case #"+(i+1)+": "+arr[i]+"\n");
        }
        bw.flush();
    }
}