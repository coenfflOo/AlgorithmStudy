package java_2025.Apr;

import java.util.*;
import java.io.*;
import java.lang.*;

public class BOJ1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(br.readLine());
            pq.add(card);
        }

        if (n==1) {
            System.out.println(0);
            return;
        }

        int suffle = 0;
        while (pq.size()>1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a+b);
            suffle += a+b;
        }
        System.out.println(suffle);
    }
}
