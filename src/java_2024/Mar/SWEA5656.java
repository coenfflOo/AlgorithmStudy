package java_2024.Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5656 {
    static int n,w,h;
    static int[][] brick;
    static boolean[][] visited;
    static int[] result;
    static int[][] copy;
    static int minBrick;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            brick = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    brick[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = new int[n];
            minBrick = Integer.MAX_VALUE;
            permBrick(0);
            System.out.println("#"+test_case+" "+minBrick);
        }
    }

    private static void permBrick(int cnt) {
        if(cnt==n) {
            copyBrick();
            // 벽돌뿌사봐라
            breakBrick();
            minBrick = Math.min(minBrick, countBrick());
            return;
        }

        for (int i = 0; i < w; i++) {
            result[cnt] = i;
            permBrick(cnt+1);
        }
    }

    private static void breakBrick() {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < h; j++) {
                if(copy[j][result[i]] != 0) {
                    bfsBrick(j, result[i]);
//                    if ((result[i]==2&&j==1) || (result[i]==2&&j==2) || (result[i]==6&&j==8)) {
//                        System.out.println("벽돌꺤다");
//                        printMap();
//                    }
                    break;
                }
            }
            getDown();
//            if (result[i]==2 || result[i]==6) {
//                System.out.println("내린다");
//                printMap();
//            }
        }
    }

    private static void bfsBrick(int startI, int startJ) {
        Queue<Brick> queue = new ArrayDeque<>();
        queue.offer(new Brick(startI, startJ));
        visited = new boolean[h][w];
        visited[startI][startJ] = true;

        while(!queue.isEmpty()) {
            Brick b = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ni = b.i;
                int nj = b.j;

                for (int i = 1; i < copy[b.i][b.j]; i++) {
                    ni += dx[k];
                    nj += dy[k];

                    if(ni>=0&&nj>=0&&ni<h&&nj<w&&!visited[ni][nj]) {
                        queue.offer(new Brick(ni,nj));
                        visited[ni][nj] = true;
                    }
                }
            }
            copy[b.i][b.j] = 0;
        }
    }

    private static void getDown() {
        for (int i = 0; i < w; i++) {
            List<Integer> exist = new ArrayList<>();
            for (int j = 0; j < h; j++) {
                if(copy[j][i]!=0) {
                    exist.add(0,copy[j][i]);
                    copy[j][i]=0;
                }
            }

            for (int j = 0; j < exist.size(); j++) {
                copy[h-1-j][i]=exist.get(j);
            }
        }
    }

    private static int countBrick() {
//        System.out.println("결과");
//        printMap();
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(copy[i][j] != 0)
                    cnt++;
            }
        }
        return cnt;
    }

    private static void copyBrick(){
        copy = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                copy[i][j] = brick[i][j];
            }
        }
    }

    private static void printMap() {
        System.out.println("=================================");
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("=================================");
    }

    static class Brick{
        int i;
        int j;

        public Brick(int i, int j) {
            super();
            this.i = i;
            this.j = j;
        }
    }
}
