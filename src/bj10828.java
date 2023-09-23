import java.util.*;
import java.io.*;
public class bj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]){
                case "push":
                    int num = Integer.parseInt(s[1]);
                    stack.push(num);
                    break;
                case "pop":
                    if (stack.empty())
                        bw.write(String.valueOf(-1)+"\n");
                    else
                        bw.write(String.valueOf(stack.pop())+"\n");
                    break;
                case "size":
                    bw.write(String.valueOf(stack.size())+"\n");
                    break;
                case "empty":
                    if (!stack.empty())
                        bw.write("0\n");
                    else
                        bw.write("1\n");
                    break;
                case "top":
                    if (stack.empty())
                        bw.write(String.valueOf(-1)+"\n");
                    else
                        bw.write(String.valueOf(stack.peek())+"\n");
                    break;
            }
            bw.flush();
        }

    }
}
