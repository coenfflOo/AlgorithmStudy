import java.util.*;
import java.io.*;
public class bj2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

//        int day = 0;
//        int sum = 0;
//        while (sum < V){
//            day++;
//            sum += A;
//            if (sum >= V)
//                break;
//            sum -= B;
//        }
        // 함수 사용 폼 미쳤다..
        // 마지막 날에는 A만큼 올라가지 않으므로 V - A로 나누어 올림한 값을 출력합니다.
        int day = (int) Math.ceil((double) (V - A) / (A - B)) + 1;

        bw.write(String.valueOf(day));
        bw.flush();
    }
}
