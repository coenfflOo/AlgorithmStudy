import java.util.*;
import java.io.*;
public class bj11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringBuilder result = factorization(N,B);
        bw.write(result.toString());
        bw.flush();
    }

    //재귀함수 생성 어려워..
    private static StringBuilder factorization(int N, int B) {
        int div = N/B;
        int num = N%B;
        StringBuilder sb = new StringBuilder();
        if (div > 0)
            sb.append(factorization(div, B));

        String str = changeStr(num);
        sb.append(str);

        return sb;
    }

    private static String changeStr(int num){
        String s = "";
        if(num>=10&&num<=35){
            s += (char)(num+55);
        }
        else
            s = String.valueOf(num);

        return s;
    }
}
