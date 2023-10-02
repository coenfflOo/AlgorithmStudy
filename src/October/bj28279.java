package October;
import java.util.*;
import java.io.*;
public class bj28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int order = Integer.parseInt(str[0]);
            switch (order){
                case 1:
                    deque.addFirst(Integer.parseInt(str[1]));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(str[1]));
                    break;
                case 3:
                    if (deque.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(String.valueOf(deque.pollFirst())+"\n");
                    break;
                case 4:
                    if (deque.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(String.valueOf(deque.pollLast())+"\n");
                    break;
                case 5:
                    bw.write(String.valueOf(deque.size())+"\n");
                    break;
                case 6:
                    if (deque.isEmpty())
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case 7:
                    if (deque.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(String.valueOf(deque.getFirst()) + "\n");
                    break;
                case 8:
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
