package java_2024.June;

import java.io.*;

public class BOJ18258 {
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {

        int N = read();
        int[] queue = new int[N];
        int tail, head;
        tail = head = 0;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (N-- > 0) {
            int op = System.in.read();
            if (op == 'p') {
                op = System.in.read();
            }
            read();
            switch (op) {
                case 'u': // push
                    queue[tail++] = read();
                    continue;
                case 'o': // pop
                    write(tail == head ? -1 : queue[head++]);
                    break;
                case 's': // size
                    write(tail - head);
                    break;
                case 'e': // empty
                    write(tail == head ? 1 : 0);
                    break;
                case 'f': // front
                    write(tail == head ? -1 : queue[head]);
                    break;
                case 'b': // back
                    write(tail == head ? -1 : queue[tail - 1]);
                    break;
            }
        }

        bw.flush();
        bw.close();
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    static void write(int num) throws IOException {
        if (num < 0) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(num));
        }
        bw.newLine();
    }
}
