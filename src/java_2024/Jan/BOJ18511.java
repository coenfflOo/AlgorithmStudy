package java_2024.Jan;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ18511 {
    static int[] numbers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        numbers = new int[k];
        int max = 0;
        for (int i = 0; i < k; i++) {
            numbers[i] = sc.nextInt();
//            if (numbers[i] < f && max < numbers[i]) {
                max = numbers[i];
//            }
        }

        Arrays.sort(numbers);
        if (max != 0) {
            System.out.print(max);
        }
        for (int i = 0; i < k - 1; i++) {
            System.out.print(numbers[k - 1]);
        }

    }

//    static void findNum(int cnt, int k){
//        int f = (int) (N / (Math.pow(10, k - 1)));
//    }
}
