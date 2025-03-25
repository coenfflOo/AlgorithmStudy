package java_2025.Mar;

import java.lang.*;
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ9440 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<n;i++){
                pq.add(Integer.parseInt(st.nextToken()));
            }

            int[] first = new int[n-n/2];
            int[] second = new int[n/2];
            int turn = 0;
            while(!pq.isEmpty()){
                if (turn == 0){
                    int cnt = 0;
                    while (pq.peek() == 0){
                        cnt++;
                        pq.poll();
                    }
                    first[turn] = pq.poll();
                    if (pq.isEmpty()) break;
                    second[turn] = pq.poll();
                    for (int i=0;i<cnt;i++){
                        pq.offer(0);
                    }
                } else {
                    first[turn] = pq.poll();
                    if (pq.isEmpty()) break;
                    second[turn] = pq.poll();
                }
                turn++;
            }
            int a = 0;
            int b = 0;
            for(int i=0;i<n-n/2;i++){
                a += first[i]*(int)Math.pow(10,n- (double) n /2-1-i);
            }
            for(int i=0;i<n/2;i++){
                b += second[i]*(int)Math.pow(10, (double) n /2-1-i);
            }
            System.out.println(a+b);
        }

    }
}
