package java_2025.Feb;
import java.io.*;
public class BOJ2023 {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        findSosu(0,sb);
    }

    private static void findSosu(int size, StringBuilder sb){
        if (size==n){
            int total = Integer.parseInt(sb.toString());
            if (!impossible(total)){
                System.out.println(total);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            sb.append(i);
            int cur = Integer.parseInt(sb.toString());
            if (!impossible(cur)){
                findSosu(size+1, sb);
            }
            sb.deleteCharAt(size);
        }
    }

    private static boolean impossible(int num){
        if (num==0) return true;
        if (num==1) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0) return true;
        }
        return false;
    }
}
