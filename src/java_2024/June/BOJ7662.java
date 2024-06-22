package java_2024.June;

import java.util.*;
import java.io.*;

public class BOJ7662 {
    static BufferedWriter bw;
    static TreeMap<Integer, Integer> tm;

    public static void main(String[] args) throws Exception {

        int T = read();
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (T-- > 0) {
            tm = new TreeMap<>();
            int N = read();
//            System.out.println(N);
            while (N-- > 0) {
                switch (System.in.read()) {
                    case 'I':
//                        System.out.println("input");
                        System.in.read();
                        int num = read();
//                        System.out.println(num);
                        tm.put(num, tm.getOrDefault(num, 0) + 1);
                        break;
                    case 'D':
                        System.in.read();
                        if (!tm.isEmpty()) {
                            switch (read()) {
                                case 1:
                                    removeKey(tm.lastKey());
                                    break;
                                case -1:
                                    removeKey(tm.firstKey());
                                    break;
                            }
                        } else {
                            read();
                        }
                        break;
                }
//                System.out.println(tm);
            }
            // Q에 남아 있는 값 중 최댓값과 최솟값
            // Q가 비어있다면 ‘EMPTY
            if (!tm.isEmpty()) {
                bw.write(tm.lastKey() + " " + tm.firstKey());
            } else {
                bw.write("EMPTY");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static void removeKey(int key) {
//        System.out.println(key);
        if (tm.get(key) - 1 == 0) {
            tm.remove(key);
        } else {
            tm.put(key, tm.get(key) - 1);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) {
            n = System.in.read() & 15;
        }

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return isNegative ? ~n + 1 : n;

    }
}
