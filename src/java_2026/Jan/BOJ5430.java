package java_2026.Jan;
import java.io.*;
import java.util.*;

public class BOJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String[] P = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            int[] arr = new int[n];

            s = s.replace('[',' ').replace(']',' ').trim();
            String[] str =  s.split(",");

            if(n!=0) {
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(str[i]);
                }
            }

            boolean forward = true;
            int left = 0;
            int right = n-1;
            boolean error = false;
            out: for(String p: P){
                switch (p){
                    case "R":
                        forward = !forward;
                        break;
                    case "D":
                        if (left > right) {
                            sb.append("error\n");
                            error = true;
                            break out;
                        }
                        if (forward) left++;
                        else right--;
                        break;
                }
            }
            if (error) continue;

            sb.append('[');
            if (forward) {
                for (int i = left; i <= right; i++) {
                    sb.append(arr[i]).append(',');
                }
            } else {
                for (int i = right; i >= left; i--) {
                    sb.append(arr[i]).append(',');
                }
            }
            if (sb.charAt(sb.length()-1) == ',') {
                sb.replace(sb.length()-1, sb.length(), "]");
            } else sb.append(']');
            sb.append('\n');
//            System.out.println(sb);
        }
        System.out.println(sb);
    }
}