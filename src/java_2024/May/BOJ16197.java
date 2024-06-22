package java_2024.May;

import java.util.*;
import java.io.*;

public class BOJ16197 {
    static int n, m;
    static String[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int res;
    static boolean possible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        List<Coin> coins = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("o")) {
                    coins.add(new Coin(i, j));
                }
            }
        }

        res = Integer.MAX_VALUE;
        combDir(1, coins);
        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    private static void combDir(int cnt, List<Coin> coins) {
        if (cnt > 10) {
            return;
        }

        for (int k = 0; k < 4; k++) {
            possible = true;
            List<Coin> nCoin = moveCoins(coins, k);
            if (possible) {
                if (nCoin.size() == 1) {
                    res = Math.min(res, cnt);
                    return;
                } else if (nCoin.size() == 2) {
                    combDir(cnt + 1, nCoin);
                }
            }
        }
    }

    private static List<Coin> moveCoins(List<Coin> coins, int dir) {
        List<Coin> nc = new ArrayList<>();
        for (Coin coin : coins) {
            int ni = coin.i + dx[dir];
            int nj = coin.j + dy[dir];

            if (ni < 0 || nj < 0 || ni >= n || nj >= m) {
                continue;
            }

            if (map[ni][nj].equals("#")) {
                if (nc.size() > 0) {
                    if (coin.i == nc.get(0).i && coin.j == nc.get(0).j) {
                        possible = false;
                    }
                }
                nc.add(new Coin(coin.i, coin.j));
            } else if (nc.size() > 0) {
                if (ni == nc.get(0).i && nj == nc.get(0).j) {
                    possible = false;
                }
                nc.add(new Coin(ni, nj));
            } else {
                nc.add(new Coin(ni, nj));
            }
        }
        return nc;
    }

    static class Coin {
        int i;
        int j;

        public Coin(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}