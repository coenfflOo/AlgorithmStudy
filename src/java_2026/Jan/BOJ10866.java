package java_2026.Jan;
import java.io.*;
import java.util.*;
public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                    } else sb.append("-1");
                    sb.append("\n");
                    break;
                case "pop_back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                    }  else sb.append("-1");
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(deque.size());
                    sb.append("\n");
                    break;
                case "empty":
                    if (!deque.isEmpty()) {
                        sb.append("0");
                    } else sb.append("1");
                    sb.append("\n");
                    break;
                case "front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekFirst());
                    } else sb.append("-1");
                    sb.append("\n");
                    break;
                case "back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekLast());
                    } else sb.append("-1");
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
