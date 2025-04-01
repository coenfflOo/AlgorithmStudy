package java_2025.Apr;
import java.io.*;
public class BOJ1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] subString = br.readLine().split("-");
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < subString.length; i++) {
            int temp = 0;
            String[] addString = subString[i].split("\\+");
            for (int j = 0; j < addString.length; j++) {
                temp += Integer.parseInt(addString[j]);
            }

            if(sum==Integer.MAX_VALUE){
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
