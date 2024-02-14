package java_2024.Jan;

import java.util.*;
import java.io.*;

public class BJ10804 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a != b) {
                nums = reverseList(nums, a, b);
            }
        }
        System.out.println(nums);
    }

    private static List<Integer> reverseList(List<Integer> nums, int a, int b) {
        List<Integer> res = new ArrayList<>(nums.subList(a - 1, b));
        Collections.reverse(res);
        int index = 0;
        List<Integer> numbers = new ArrayList<>(nums);
        for (int i = a - 1; i <= b - 1; i++) {
            numbers.set(i, res.get(index));
            index++;
        }
        return numbers;
    }
}
