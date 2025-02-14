package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ14888 {
    private static int n, max, min;
    private static int[] arr;
    private static String[] symbol;
    private static String[] select;
    private static boolean[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int op = Integer.parseInt(st.nextToken());
            for (int j = 0; j < op; j++) {
                if (i==0){
                    sb.append("+");
                } else if (i==1){
                    sb.append("-");
                } else if (i==2) {
                    sb.append("*");
                } else {
                    sb.append("/");
                }
            }
        }
        symbol = sb.toString().split("");
        select = new String[n-1];
        selected = new boolean[n-1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        operation(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void operation(int cnt){
        if(cnt==n-1){
            int cur = arr[0];
            for (int i = 0; i < n-1; i++) {
                cur = calculation(cur, arr[i+1],select[i]);
            }
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            return;
        }

        for (int i = 0; i < n-1; i++) {
            if (selected[i])
                continue;
            selected[i] = true;
            select[cnt] = symbol[i];
            operation(cnt+1);
            selected[i] = false;
        }
    }

    private static int calculation(int cur, int next, String op){
        switch (op){
            case "+":
                return cur + next;
            case "-":
                return cur - next;
            case "*":
                return cur * next;
            case "/":
                if(cur<0&&next>0){
                    return -1 * (Math.abs(cur)/Math.abs(next));
                } else return cur/next;
        }
        return -1;
    }
}
