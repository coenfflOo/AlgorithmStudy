package java_2026.Jan;
import java.util.*;
import java.io.*;
public class BOJ6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Building> stack = new Stack<>();
        long sum = 0;
        for (int i = N-1; i >= 0; i--) {
            int cnt = 1;
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek().height < arr[i]) {
                    sum += stack.peek().cnt;
                    cnt += stack.peek().cnt;
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek().height == arr[i]){
                    while (!stack.isEmpty() && stack.peek().height == arr[i]) {
                        cnt += stack.peek().cnt;
                        stack.pop();
                    }
                }
            }
            stack.push(new Building(arr[i], cnt));
//            System.out.println(sum);
        }
        System.out.println(sum);
    }

    static class Building {
        int height;
        int cnt;
        public Building(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }
}
