import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        String numB = br.readLine();
        int B = Integer.parseInt(numB);
        for (int i = numB.length()-1; i >= 0 ; i--) {
            int num = Integer.parseInt(String.valueOf((numB.charAt(i))));
            System.out.println(A*num);
        }
        System.out.println(A*B);
    }
}