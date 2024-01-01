package java_2023.October;
import java.io.*;
public class bj9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int result = checkSum(n);
            sb.append(result+"\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static int checkSum(int n){
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else if (n == 3)
            return 4;
        else
            return checkSum(n-1)+checkSum(n-2)+checkSum(n-3);
    }
}