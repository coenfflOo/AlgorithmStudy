import java.io.*;
import java.util.StringTokenizer;

public class bj2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        String[] str = s.split("");
        int[] arr = new int[str.length];

        for (int i = 0; i <str.length; i++) {
            int c = str[i].charAt(0);
            if (!isInteger(str[i])){
                String sc = String.valueOf(c-55);
                arr[i] = Integer.parseInt(str[i].replace(str[i], sc));
            }
            else {
                arr[i] = Integer.parseInt(str[i]);
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]*Math.pow(N,(arr.length-i-1));
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }

    // 정수 인지 확인
    public static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
