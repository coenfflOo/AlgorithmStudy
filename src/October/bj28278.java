package October;
import java.util.*;
import java.io.*;
public class bj28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            switch (Integer.parseInt(s[0])){
                case 1:
                    stack.push(Integer.parseInt(s[1]));
                    break;
                case 2:
                    if (!stack.empty())
                        bw.write(stack.pop()+"\n");
                    else
                        bw.write("-1\n");
                    break;
                case 3:
                    bw.write(stack.size()+"\n");
                    break;
                case 4:
                    if (stack.empty())
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case 5:
                    if (!stack.empty())
                        bw.write(stack.peek()+"\n");
                    else
                        bw.write("-1\n");
                    break;
            }
        }
        bw.close();
    }
}