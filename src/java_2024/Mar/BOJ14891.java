package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ14891 {
    static List<Round> rounds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        rounds = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            rounds.add(new Round(br.readLine().split("")));
        }

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            boolean direction = dir == 1;
            // 2,3번의 경우 돌릴 톱니의 2번과 +1톱니의 6번 비교 돌릴 톱니의 6번과 -1톱니의 2번비교
            // 1번의 경우 돌릴 톱니의 2번과 +1톱니의 6번 비교
            // 4번의 경우 돌릴 톱니의 6번과 -1톱니의 2번 비교
            if (number == 0) {
                toTheRight(number, direction);
            } else if (number == 3) {
                toTheLeft(number, direction);
            } else {
                toTheRight(number, direction);
                toTheLeft(number, direction);
            }
            rounds.get(number).change(direction);
        }

        System.out.println(calculate());
    }

    static void toTheRight(int number, boolean dir) {
        if (number + 1 < 4 && rounds.get(number).ns[2] != rounds.get(number + 1).ns[6]) {
            toTheRight(number + 1, !dir);
            rounds.get(number + 1).change(!dir);
        }
    }

    static void toTheLeft(int number, boolean dir) {
        if (number - 1 >= 0 && rounds.get(number).ns[6] != rounds.get(number - 1).ns[2]) {
            toTheLeft(number - 1, !dir);
            rounds.get(number - 1).change(!dir);
        }
    }

    static int calculate() {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (rounds.get(i).ns[0] == 1) {
                score += (int) Math.pow(2, i);
            }
        }
        return score;
    }

    static void print() {
        System.out.println("=================");
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(rounds.get(i).ns));
        }
        System.out.println("=================");
    }

    static class Round {
        int[] ns;

        public Round(String[] str) {
            this.ns = new int[8];
            for (int i = 0; i < 8; i++) {
                this.ns[i] = Integer.parseInt(str[i]);
            }
        }

        void change(boolean dir) {
            if (dir) {
                changeRight();
            } else {
                changeLeft();
            }
        }

        void changeRight() { // 시계방향으로
            int temp = this.ns[7];
            for (int i = 6; i >= 0; i--) {
                this.ns[i + 1] = this.ns[i];
            }
            this.ns[0] = temp;
        }

        void changeLeft() { // 반시계방향으로
            int temp = this.ns[0];
            for (int i = 1; i < 8; i++) {
                this.ns[i - 1] = this.ns[i];
            }
            this.ns[7] = temp;
        }
    }
}