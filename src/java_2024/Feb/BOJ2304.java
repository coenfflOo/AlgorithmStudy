package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ2304 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> pillar = new HashMap<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (c > max) {
                max = c;
            }
            pillar.put(r, c);
        }
        Object[] pillarKey = pillar.keySet().toArray();
        Arrays.sort(pillarKey);

        Stack<Pillar> stack = new Stack<>();

        int res = 0;
        for (int i = 0; i < N; i++) {
            int r = (int) pillarKey[i];
            int h = pillar.get(r);

            int startRow = 0, startCol = 0;
            while (!stack.isEmpty() && stack.peek().height < h) {
                startRow = stack.peek().row;
                startCol = stack.peek().height;
                stack.pop();
            }

            if (stack.isEmpty()) {
                res += (r - startRow) * startCol;
            }
            stack.push(new Pillar(r, h));
        }

        if (!stack.isEmpty()) {

            while (!stack.isEmpty()) {
                int lr = stack.peek().row;
                int lh = stack.pop().height;
                if (lh == max) {
                    int r = lr;
                    while (!stack.isEmpty() && stack.peek().height == lh) {
                        r = stack.pop().row;
                    }
                    res += (lr - r + 1) * lh;
                } else if (stack.peek().height <= lh) {
                    stack.pop();
                } else {
                    res += (lr - stack.peek().row) * lh;
                }
            }

        }
        System.out.println(res);
    }

    static class Pillar {
        int row, height;

        Pillar(int r, int h) {
            row = r;
            height = h;
        }
    }
}
