package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        for (int i = 0; i < N; i++){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < N; i++){
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}
