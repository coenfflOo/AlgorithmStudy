package java_2024.Jan;

import java.util.*;
import java.io.*;

public class BJ1267 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sumY = 0;
        int sumM = 0;
        for (int i = 0; i < N; i++) {
            int time = sc.nextInt();
            sumY += calY(time);
            sumM += calM(time);
        }

        if (sumM > sumY) {
            System.out.println("Y " + sumY);
        } else if (sumY > sumM) {
            System.out.println("M " + sumM);
        } else {
            System.out.println("Y M " + sumM);
        }
    }

    private static int calY(int time) {
        int money = 0;
        money += (time / 60) * 20;
        if (time % 60 < 30) {
            money += 10;
        } else {
            money += 20;
        }
        return money;
    }

    private static int calM(int time) {
        int money = 0;
        money += (time / 120) * 30;
        if (time % 120 < 60) {
            money += 15;
        } else {
            money += 30;
        }
        return money;
    }
}
