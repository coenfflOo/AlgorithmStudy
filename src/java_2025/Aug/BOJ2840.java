package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;

import static java.lang.System.exit;

public class BOJ2840 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(null, "?");
        for (int i = 0; i < n; i++) nodes[i].next = nodes[(i + 1) % n];
        int cursor = 0;
        Set<String> used = new HashSet<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            cursor = (cursor+Integer.parseInt(st.nextToken()))%n;
            String op = st.nextToken();
            Node cur = nodes[cursor];
            if (used.contains(op) && !cur.val.equals(op)) {
                System.out.println("!");
                exit(0);
            }
            if (!cur.val.equals("?") && !cur.val.equals(op)) {
                System.out.println("!");
                exit(0);
            }
            cur.val = op;
            used.add(op);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int idx = (cursor - i + n) % n;
            String v = nodes[idx].val;
            sb.append(v);
        }
        System.out.println(sb);
    }

    static class Node {
        Node next;
        Node prev;
        String val;
        public Node(Node next, String val) {
            this.next = next;
            this.val = val;
        }
    }
}
