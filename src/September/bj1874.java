package September;
import java.util.*;
import java.io.*;
public class bj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list  = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        boolean impossible = true;
        for (int i = 1; i+1 < n; i++) {
            if (list.get(i-1)> list.get(i) && list.get(i)<list.get(i+1)&&i+1==n-1) {
                impossible = false;
                System.out.println("NO");
            }
        }
        if (impossible) {
            Stack<Integer> stack = new Stack<>();
            int number = 1;
            int listIndex = 0;
            while (true) {
                if (number <= n) {
                    stack.push(number);
                    System.out.println("+");
                    number++;
                }
                while (!stack.empty() && Objects.equals(stack.peek(), list.get(listIndex))) {
                    stack.pop();
                    System.out.println("-");
                    listIndex++;
                }

                if (stack.empty() && number == n + 1)
                    break;
            }
        }
    }
}
// 1 2 3 4 5 6 7 8
// 4 3 6 8 7 5 2 1
// 1 2 5 7 8 6 3 4

// 1 2 3 4
// 1 2
// 1 2 5 6
// 1 2 5
// 1 2 5 7 8

// 4 3 6 8 7 5 2 1