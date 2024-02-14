package java_2024.Jan;

import java.util.*;

public class SWEA1208 {
    static int[] boxes = new int[100];
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int dumpTime = sc.nextInt();
            for (int i = 0; i < 100; i++) {
                boxes[i] = sc.nextInt();
            }
            System.out.print("#"+test_case+" ");
            dump(dumpTime);
        }
    }

    private static void dump(int dumpTime) {

        int maxIndex = 0;
        int minIndex = 0;
        int max = 0;
        int min = 100;
        for (int i = 0; i < 100; i++) {
            if (boxes[i]<min) {
                min = boxes[i];
                minIndex = i;
            }
            if (boxes[i]>max) {
                max = boxes[i];
                maxIndex = i;
            }
        }
        if (dumpTime == 0) {
            System.out.println(max-min);
            return;
        }
        boxes[minIndex] = boxes[minIndex]+1;
        boxes[maxIndex] = boxes[maxIndex]-1;
        dump(dumpTime-1);
    }
}
