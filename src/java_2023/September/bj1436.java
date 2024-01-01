package java_2023.September;
import java.io.*;
public class bj1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int number = 665;
        if (N == 0 )
            bw.write(String.valueOf(666));
        else {
            while (N != 0){
                number++;
                if (deadNum(number)){
                    N--;
                }
            }
        }
        bw.write(String.valueOf(number));
        bw.flush();
    }

    private static boolean deadNum(int n){
        String s = String.valueOf(n);
        if (s.contains("666"))
            return true;
        else
            return false;
    }
}
