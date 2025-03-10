package java_2025.Feb.Study;
import java.util.*;
import java.io.*;
public class BOJ14888_2 {
    private static int n, max, min;
    private static int[] number, operation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        operation = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        int[] op = new int[4];
        permCal(0,number[0], op);
        System.out.println(max);
        System.out.println(min);
    }

    private static void permCal(int cnt, int cur, int[] op){
        if (cnt == n-1){
            min = Math.min(min, cur);
            max = Math.max(max, cur);
            return;
        }

        if (op[0] != operation[0]){
            op[0]++;
            permCal(cnt+1, cur+number[cnt+1], op);
            op[0]--;
        }
        if (op[1]!= operation[1]){
            op[1]++;
            permCal(cnt+1, cur-number[cnt+1], op);
            op[1]--;
        }
        if (op[2] != operation[2]){
            op[2]++;
            permCal(cnt+1, cur*number[cnt+1], op);
            op[2]--;
        }if (op[3] != operation[3]){
            op[3]++;
            int next = cur<0? Math.abs(cur)/number[cnt+1]*-1:cur/number[cnt+1];
            permCal(cnt+1, next, op);
            op[3]--;
        }

    }
}
