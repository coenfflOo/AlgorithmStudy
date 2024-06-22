package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ17143 {
    static int r, c;
    static Shark[][] sharkPan;
    static List<Shark> sharks;
    static int sizeSum;
    static Shark[][] copy;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m == 0) {
            System.out.println("0");
            return;
        }

        sharkPan = new Shark[r][c];
        sharks = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken()) - 1;
            int sc = Integer.parseInt(st.nextToken()) - 1;
            int ss = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int sz = Integer.parseInt(st.nextToken());
            sharks.add(new Shark(sr, sc, ss, sd, sz));
            sharkPan[sr][sc] = new Shark(sr, sc, ss, sd, sz);
        }

        sizeSum = 0;
        // 낚시꾼 이동해 - 낚시꾼이 있는 열에서 상어 잡을 수 있어
        for (int fishMan = 0; fishMan < c; fishMan++) {
            // 잡아따 요놈!
            killShark(fishMan);
            // 다들 이동해 샤샤샥
            moveShark();
        }
        System.out.println(sizeSum);
    }

    private static void killShark(int fishMan) {
        for (int fr = 0; fr < r; fr++) {
            if(sharkPan[fr][fishMan] != null){
                sizeSum += sharkPan[fr][fishMan].z;
                sharkPan[fr][fishMan] = null;
                break;
            }
        }
    }

    private static void moveShark() {
        copy = new Shark[r][c];
        List<Shark> toRemove = new ArrayList<>();
        for (Shark s: sharks) {
            if (sharkPan[s.r][s.c]==null){
                toRemove.add(s);
                continue;
            }

            int speed = s.s;
            speed %= (s.d==1||s.d==2)? 2*(r-1) : 2*(c-1);

            while (speed-->0){
                if(isChangeDir(s)) {
                    s.changeDir();
                }
                s.r += dx[s.d];
                s.c += dy[s.d];
            }

            Shark ds = sharkRoom(s);
            if (ds != null)
                toRemove.add(ds);
        }
        sharks.removeAll(toRemove);

//        printShark();
        sharkPan = copy;
    }

    public static boolean isChangeDir(Shark s){
        return (s.d == 1 && s.r == 0) || (s.d == 2 && s.r == r - 1) || (s.d == 3 && s.c == c - 1) || (s.d == 4
                && s.c == 0);
    }

    private static Shark sharkRoom(Shark s) {
        Shark e = copy[s.r][s.c];
        if (e == null) {
            copy[s.r][s.c] = s;
        } else {
            if (e.z < s.z) {
                copy[s.r][s.c] = s;
                return e;
            } else if (e.z > s.z){
                return s;
            }
        }
        return null;
    }

    public static class Shark {
        int r;
        int c;
        int s; // 속력
        int d; // 이동 방향
        int z; // 크기

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    '}';
        }

        private void changeDir() {
            switch (this.d) {
                case 1 :
                    this.d = 2;
                    break;
                case 2 :
                    this.d = 1;
                    break;
                case 3 :
                    this.d = 4;
                    break;
                case 4 :
                    this.d = 3;
                    break;
                default :
                    this.d = -1; // 잘못된 경우 -1 반환
                    break;
            };
        }
    }

    static void printShark() {
        System.out.println("================================");
        for (Shark s : sharks) {
            System.out.println(s);
        }
        System.out.println("================================");
    }

    static void printSharkPan() {
        System.out.println("================================");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sharkPan[i][j] == null) {
                    System.out.print("0 ");
                }else {
                    System.out.print(sharkPan[i][j].z + " ");
                }
            }
            System.out.println();
        }
        System.out.println("================================");
    }
}
