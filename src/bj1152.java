import java.util.*;
import java.io.*;
public class bj1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        // 문자열 양쪽의 공백을 제거하여 시작과 끝의 공백을 처리합니다.
        s = s.trim();

        // 빈 문자열인 경우
        if (s.isEmpty()) {
            bw.write(String.valueOf(0));
        } else {
            String[] str = s.split(" ");
            bw.write(String.valueOf(str.length));
        }

        bw.flush();
    }
}
// 다른 문자 없이 공백 하나만 입력되는 경우 1을 출력하므로 0을 출력하도록 하기
