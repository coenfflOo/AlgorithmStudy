package October;
import java.util.*;
import java.io.*;
public class bj18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            switch (str[0]){
                case "push":
                    deque.add(Integer.parseInt(str[1]));
                    break;
                case "pop":
                    if (deque.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(String.valueOf(deque.pop())+"\n");
                    break;
                case "size":
                    bw.write(String.valueOf(deque.size())+"\n");
                    break;
                case "empty":
                    if (deque.isEmpty())
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case "front":
                    if (deque.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(String.valueOf(deque.getFirst()) + "\n");
                    break;
                case "back":
                    if (deque.isEmpty())
                        bw.write("-1\n");
                    else {
                        bw.write(String.valueOf(deque.peekLast()) + "\n");
                    }
                    break;
            }
        }
        bw.close();
    }
}
