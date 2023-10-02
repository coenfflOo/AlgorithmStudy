package October;

import java.util.*;
import java.io.*;

public class bj12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> studentStack = new Stack<>();
        String[] num = br.readLine().split("");
        int number = 1;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(num[i]);
            while (!studentStack.isEmpty() && studentStack.peek() == number) {
                studentStack.pop();
                number++;
            }

            if (n == number) {
                number++;
            } else {
                studentStack.push(n);
            }
        }

        while (!studentStack.isEmpty() && studentStack.peek() == number) {
            studentStack.pop();
            number++;
        }

        if (number == N + 1)
            System.out.println("Nice");
        else
            System.out.println("Sad");
    }
}
