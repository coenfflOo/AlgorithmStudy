package java_2025.Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16987 {
    private static int n, max;
    private static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        eggs = new Egg[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        max = 0;
        backtrack(0);
        System.out.println(max);
    }

    private static void backtrack(int hand) {
        if (hand == n) { // 모든 계란을 들었을 때
            int count = 0;
            for (Egg egg : eggs) {
                if (egg.power <= 0) count++;
            }
            max = Math.max(max, count);
            return;
        }

        // 현재 손에 든 계란이 이미 깨진 경우 -> 그냥 다음으로 넘어감
        if (eggs[hand].power <= 0) {
            backtrack(hand + 1);
            return;
        }

        boolean hit = false; // 한 번이라도 충돌했는지 체크
        for (int i = 0; i < n; i++) {
            if (i == hand || eggs[i].power <= 0) continue; // 자기 자신이거나 이미 깨진 계란이면 패스

            // 계란 충돌
            eggs[hand].power -= eggs[i].weight;
            eggs[i].power -= eggs[hand].weight;
            hit = true;

            backtrack(hand + 1); // 다음 계란으로 이동

            // 원상복구 (백트래킹)
            eggs[hand].power += eggs[i].weight;
            eggs[i].power += eggs[hand].weight;
        }

        // 깨지지 않은 다른 계란이 없어서 충돌하지 못한 경우 -> 그냥 다음 계란으로 넘어감
        if (!hit) backtrack(hand + 1);
    }

    private static class Egg {
        int power;
        int weight;

        public Egg(int power, int weight) {
            this.power = power;
            this.weight = weight;
        }
    }
}