package java_2024.Feb;

import java.util.*;

public class SWEA1225 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int test_case = sc.nextInt();
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < 8; i++) {
                queue.add(sc.nextInt());
            }

            int num = 1;
            int count = 1;
            while (num != 0) {
                num = queue.poll() - count++;
                if (num <= 0) {
                    num = 0;
                }
                queue.add(num);
                if (count == 6) {
                    count = 1;
                }
            }
            System.out.print("#" + test_case + " ");
            for (int number :
                    queue) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
