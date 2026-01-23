package java_2026.Jan;
import java.util.*;
import java.io.*;
public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        int last = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num;
            switch (str){
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    queue.offer(num);
                    last = num;
                    break;
                case "pop":
                    if (!queue.isEmpty()) {
                        sb.append(queue.poll()).append('\n');
                    } else {
                        sb.append("-1").append('\n');
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append("1").append('\n');
                    } else {
                        sb.append("0").append('\n');
                    }
                    break;
                case "front":
                    if (!queue.isEmpty()) {
                        sb.append(queue.peek()).append('\n');
                    } else {
                        sb.append("-1").append('\n');
                    }
                    break;
                case "back":
                    if (!queue.isEmpty()) {
                        sb.append(last).append('\n');
                    } else {
                        sb.append("-1").append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
