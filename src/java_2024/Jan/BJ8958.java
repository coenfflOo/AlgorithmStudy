package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ8958 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for (int i = 0; i < test_case; i++) {
            String[] result = sc.next().split("");
            int score = calculateScore(result);
            System.out.println(score);
        }
    }

    private static int calculateScore(String[] result) {
        int sum = 0;
        int scope = 1;
        for (int i = 0; i < result.length; i++) {
            if (result[i].equals("O")){
                sum+=scope;
                scope++;
            } else {
                scope = 1;
            }
        }
        return sum;
    }
}
