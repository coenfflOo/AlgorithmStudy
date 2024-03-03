package java_2024.Mar;

import java.util.*;
import java.io.*;

public class SWEA2382 {
    static int n, m, k;
    static List<Microbiota> microbiota;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt(); // cell 크기
            m = sc.nextInt(); // 시간
            k = sc.nextInt(); // 미생물 수

            microbiota = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                int ni = sc.nextInt();
                int nj = sc.nextInt();
                int m = sc.nextInt();
                int dir = sc.nextInt();
                microbiota.add(new Microbiota(ni, nj, m, dir));
            }

//            for (Microbiota m :
//                    microbiota) {
//                System.out.println(m.i+" "+m.j+" "+m.toString());
//            }

            for (int i = 0; i < m; i++) {
                moveMicrobiota();
            }
            System.out.println("#" + test_case + " " + countMicrobe());
        }
    }

    private static int countMicrobe() {
        int cnt = 0;
        for (Microbiota mb :
                microbiota) {
            cnt += mb.microbe;
        }
        return cnt;
    }

    private static void moveMicrobiota() {
        List<Microbiota> newM = new ArrayList<>();
        List<Microbiota> resM = new ArrayList<>();
        for (Microbiota mb : microbiota) {
            mb.i = mb.i + dx[mb.dir];
            mb.j = mb.j + dy[mb.dir];

            // 약품에 닿았을 때
            if (mb.i == 0 || mb.j == 0 || mb.i == n - 1 || mb.j == n - 1) {
                mb.microbe /= 2;
                mb.changeDir();
                if (mb.microbe == 0) {
                    continue;
                }
            }

            newM.add(new Microbiota(mb.i, mb.j, mb.microbe, mb.dir));
        }

        Collections.sort(newM);
        int idx = 0;

        for (int i = 0; i < newM.size(); i++) {
            Microbiota nm = newM.get(i);
            if (i != 0) {
                if (resM.get(idx - 1).i == nm.i && resM.get(idx - 1).j == nm.j) {
                    Microbiota rm = resM.get(idx - 1);
                    resM.set(idx - 1, new Microbiota(rm.i, rm.j, rm.microbe + nm.microbe, rm.dir));
                    continue;
                }
            }
            resM.add(nm);
            idx++;
        }

//        System.out.println("newM");
//        for (Microbiota nm :
//                newM) {
//            System.out.println(nm.i+" "+nm.j+" "+ nm.microbe+" "+nm.toString());
//        }
//        System.out.println("------------------");
//        System.out.println("resM");
//        for (Microbiota nm :
//                resM) {
//            System.out.println(nm.i+" "+nm.j+" "+ nm.microbe+" "+nm.toString());
//        }
//        System.out.println("------------------");
        microbiota = resM;
    }

    static class Microbiota implements Comparable<Microbiota> {
        int i;
        int j;
        int microbe; // 미생물의 수
        int dir; // 이동방향

        public Microbiota(int i, int j, int microbe, int dir) {
            this.i = i;
            this.j = j;
            this.microbe = microbe;
            this.dir = dir;
        }

        void changeDir() {
            switch (this.dir) {
                case 1:
                    this.dir = 2;
                    break;
                case 2:
                    this.dir = 1;
                    break;
                case 3:
                    this.dir = 4;
                    break;
                case 4:
                    this.dir = 3;
                    break;
            }
        }

        @Override
        public String toString() {
            String s = "--";
            switch (this.dir) {
                case 1:
                    s = "^";
                    break;
                case 2:
                    s = "v";
                    break;
                case 3:
                    s = "<";
                    break;
                case 4:
                    s = ">";
                    break;

            }
            return s;
        }

        @Override
        public int compareTo(Microbiota o) {
            if (i > o.i) {
                return 1;
            } else if (i == o.i) {
                if (j > o.j) {
                    return 1;
                } else if (j == o.j) {
                    if (microbe < o.microbe) {
                        return 1;
                    } else if (microbe == o.microbe) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }
}
