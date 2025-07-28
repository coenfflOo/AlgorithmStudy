package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (maxH.size() == minH.size()) {
                maxH.offer(num);
            } else {
                minH.offer(num);
            }
            if (!minH.isEmpty() && maxH.peek() > minH.peek()) {
                int max = maxH.poll();
                int min = minH.poll();
                maxH.offer(min);
                minH.offer(max);
            }
            System.out.println(maxH.peek());

        }
    }
}
