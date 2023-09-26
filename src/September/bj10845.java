import java.util.*;
import java.io.*;
public class bj10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]){
                case "push":
                    int num = Integer.parseInt(s[1]);
                    queue.offer(num);
                    break;
                case "pop":
                    if (queue.isEmpty())
                        bw.write(String.valueOf(-1)+"\n");
                    else
                        bw.write(String.valueOf(queue.poll())+"\n");
                    break;
                case "size":
                    bw.write(String.valueOf(queue.size())+"\n");
                    break;
                case "empty":
                    if (!queue.isEmpty())
                        bw.write("0\n");
                    else
                        bw.write("1\n");
                    break;
                case "front":
                    if (queue.isEmpty())
                        bw.write(String.valueOf(-1)+"\n");
                    else
                        bw.write(String.valueOf(queue.peek())+"\n");
                    break;
                case "back":
                    if (queue.isEmpty())
                        bw.write(String.valueOf(-1)+"\n");
                    else{
                        for (int j = 0; j < queue.size()-1; j++) {
                            queue.offer(queue.poll());
                        }
                        int lastElement = queue.poll();
                        bw.write(String.valueOf(lastElement)+"\n");
                        queue.offer(lastElement);
                    }
                    break;
            }
            bw.flush();
        }

    }
}
