import java.io.*;
import java.util.StringTokenizer;

public class bj10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s; //런타입에러(NullPointer) 시 에러발생. 이렇게 작성하는 연습하기
        while ((s=br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(s);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A==0&&B==0)
                break;
            System.out.println(A+B);
        }

    }
}
