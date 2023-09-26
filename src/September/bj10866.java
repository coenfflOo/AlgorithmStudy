import java.util.*;
import java.io.*;

public class bj10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "push_front":
                    int num = Integer.parseInt(s[1]);
                    deque.addFirst(num);
                    break;
                case "push_back":
                    int num2 = Integer.parseInt(s[1]);
                    deque.addLast(num2);
                    break;
                case "pop_front":
                    if (deque.isEmpty())
                        bw.write(String.valueOf(-1) + "\n");
                    else
                        bw.write(String.valueOf(deque.pollFirst()) + "\n");
                    break;
                case "pop_back":
                    if (deque.isEmpty())
                        bw.write(String.valueOf(-1) + "\n");
                    else
                        bw.write(String.valueOf(deque.pollLast()) + "\n");
                    break;
                case "size":
                    bw.write(String.valueOf(deque.size()) + "\n");
                    break;
                case "empty":
                    if (!deque.isEmpty())
                        bw.write("0\n");
                    else
                        bw.write("1\n");
                    break;
                case "front":
                    if (deque.isEmpty())
                        bw.write(String.valueOf(-1) + "\n");
                    else
                        bw.write(String.valueOf(deque.peekFirst()) + "\n");
                    break;
                case "back":
                    if (deque.isEmpty())
                        bw.write(String.valueOf(-1) + "\n");
                    else
                        bw.write(String.valueOf(deque.peekLast()) + "\n");
                    break;
            }
            bw.flush();
        }
    }
}
