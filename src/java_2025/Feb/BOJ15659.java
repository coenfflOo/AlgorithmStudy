package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ15659 {
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
            int cur = calculate();
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

    private static int calculate() {
        Stack<Integer> num = new Stack<>();
        num.push(arr[0]);
        Stack<String> op = new Stack<>();
        for (int i = 0; i < n-1; i++) {
            if (select[i].equals("+")||select[i].equals("-")){
                op.push(select[i]);
                num.push(arr[i+1]);
            } else {
                int prev = num.pop();
                int cur = arr[i+1];
                int result = calculation(cur, prev, select[i]);
                num.push(result);
            }
        }
//        System.out.println(num);
//        System.out.println(op);

        List<Integer> list = new ArrayList<>();
        int size = num.size();
        while (!num.isEmpty()){
            list.add(num.pop());
        }
        for (int i = 0; i < size; i++) {
            num.push(list.get(i));
        }

        List<String> stringList = new ArrayList<>();
        size = op.size();
        while (!op.isEmpty()){
            stringList.add(op.pop());
        }
        for (int i = 0; i < size; i++) {
            op.push(stringList.get(i));
        }

//        System.out.println(num);
//        System.out.println(op);

        while (num.size()>=2){
            int cur = num.pop();
            int prev = num.pop();
            String s = op.pop();
            int result = calculation(cur, prev, s);
//            System.out.println(cur+s+prev+"="+result);
            num.push(result);
        }
        return num.pop();
    }
    private static int calculation(int cur, int prev, String op){
        switch (op){
            case "+":
                return cur + prev;
            case "-":
                return cur - prev;
            case "*":
                return cur * prev;
            case "/":
                return prev/cur;
        }
        return -1;
    }
}
