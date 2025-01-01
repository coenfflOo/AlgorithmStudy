package java_2024.June;
import java.util.*;
import java.io.*;
public class BOJ13913 {
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            System.out.println(k);
            return;
        }
        int[] visited = new int[100001];
        Queue<Integer> queue = new ArrayDeque<>();
        Arrays.fill(visited, -1);
        queue.offer(n);
        visited[n] = 0;
        int time = 1;
        out: while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                int now = queue.poll();
                for (int d = 1; d <= 3; d++) {
                    int next = calculate(now, d);

                    if (next<0||next>=100001||visited[next]!=-1)
                        continue;

                    if (next == k) {
                        visited[next] = now;
                        break out;
                    }
                    else {
                        queue.offer(next);
                        visited[next] = now;
                    }
                }
            }
            time++;
        }
        bw.write(String.valueOf(time));
        bw.newLine();

        int start = k;
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        for (int i = 0; i < time; i++) {
            stack.push(visited[start]);
            start = visited[start];
        }
        while (!stack.isEmpty()){
            bw.write(String.valueOf(stack.pop())+" ");
        }
        bw.flush();
        bw.close();
    }

    private static int calculate(int now, int k) {
        switch (k){
            case 1:
                return now-1;
            case 2:
                return now+1;
            case 3:
                return now*2;
        }
        return -1;
    }
}
