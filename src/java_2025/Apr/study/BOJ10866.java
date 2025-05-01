package java_2025.Apr.study;
import java.util.*;
import java.io.*;
public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<String> q = new ArrayDeque<>();
        while (n-->0){
            String[] str = br.readLine().split(" ");
            switch (str[0]){
                case "push_front":
                    q.addFirst(str[1]);
                    break;
                case "push_back":
                    q.addLast(str[1]);
                    break;
                case "pop_front":
                    if (q.isEmpty()) System.out.println("-1");
                    else System.out.println(q.pop());
                    break;
                case "pop_back":
                    if (q.isEmpty()) System.out.println("-1");
                    else {
                        System.out.println(q.getLast());
                        q.removeLast();
                    }
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if (q.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "front":
                    if (q.isEmpty()) System.out.println("-1");
                    else System.out.println(q.getFirst());
                    break;
                case "back":
                    if (q.isEmpty()) System.out.println("-1");
                    else System.out.println(q.getLast());
                    break;
            }
        }
    }
}
