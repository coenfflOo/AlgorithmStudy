package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ15828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        int order;
        while ((order = Integer.parseInt(br.readLine())) != -1) {
            if (order == 0) {
                queue.poll();
            } else {
                if (queue.size() < n) queue.offer(order);
            }
        }

        if (queue.isEmpty()){
            System.out.println("empty");
            return;
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll()+" ");
        }
    }
}
