package java_2025.Jan.swea2;

import java.util.*;

class UserSolution {
    int W, H;
    int[][] board;
    int[] score;

    void init(int W, int H) {
        this.W = W;
        this.H = H;
        board = new int[H][W];
        score = new int[2];
    }

    int dropBlocks(int mPlayer, int mCol) {
        for (int i = 0; i < 3; i++) {
            int c = mCol + i;
            int r = findDropRow(c);
            if (r >= 0) board[r][c] = mPlayer;
        }
        return removeAndScore(mPlayer);
    }

    int changeBlocks(int mPlayer, int mCol) {
        int row = findHighestRow(mCol);
        if (row >= 0) {
            int color = board[row][mCol];
            if (color != 0 && color != mPlayer) flipBlocks(row, mCol, color, mPlayer);
        }
        return removeAndScore(mPlayer);
    }

    int getResult(int[] mBlockCnt) {
        int p1 = 0, p2 = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (board[r][c] == 1) p1++;
                else if (board[r][c] == 2) p2++;
            }
        }
        mBlockCnt[0] = p1;
        mBlockCnt[1] = p2;
        if (score[0] > score[1]) return 1;
        if (score[1] > score[0]) return 2;
        return 0;
    }

    int removeAndScore(int mPlayer) {
        int sum = 0;
        while (true) {
            Set<Point> p1Set = new HashSet<>();
            Set<Point> p2Set = new HashSet<>();
            findRemoves(1, p1Set);
            findRemoves(2, p2Set);
            if (p1Set.isEmpty() && p2Set.isEmpty()) break;
            int c1 = p1Set.size();
            int c2 = p2Set.size();
            for (Point p : p1Set) board[p.r][p.c] = 0;
            for (Point p : p2Set) board[p.r][p.c] = 0;
            if (mPlayer == 1) sum += c1;
            else sum += c2;
            applyGravity();
        }
        score[mPlayer - 1] += sum;
        return sum;
    }

    void findRemoves(int color, Set<Point> removeSet) {
        for (int r = 0; r < H; r++) checkHorizontal(r, color, removeSet);
        for (int c = 0; c < W; c++) checkVertical(c, color, removeSet);
        List<List<Point>> d1 = diagDownRight();
        for (List<Point> line : d1) checkDiagonal(line, color, removeSet);
        List<List<Point>> d2 = diagDownLeft();
        for (List<Point> line : d2) checkDiagonal(line, color, removeSet);
    }

    void checkHorizontal(int r, int ccol, Set<Point> set) {
        int cnt = 0, start = 0;
        for (int c = 0; c < W; c++) {
            if (board[r][c] == ccol) {
                if (cnt == 0) start = c;
                cnt++;
            } else {
                if (cnt >= 5) {
                    for (int x = start; x < start + cnt; x++) set.add(new Point(r, x));
                }
                cnt = 0;
            }
        }
        if (cnt >= 5) {
            for (int x = start; x < start + cnt; x++) set.add(new Point(r, x));
        }
    }

    void checkVertical(int c, int ccol, Set<Point> set) {
        int cnt = 0, start = 0;
        for (int r = 0; r < H; r++) {
            if (board[r][c] == ccol) {
                if (cnt == 0) start = r;
                cnt++;
            } else {
                if (cnt >= 5) {
                    for (int x = start; x < start + cnt; x++) set.add(new Point(x, c));
                }
                cnt = 0;
            }
        }
        if (cnt >= 5) {
            for (int x = start; x < start + cnt; x++) set.add(new Point(x, c));
        }
    }

    void checkDiagonal(List<Point> line, int ccol, Set<Point> set) {
        int cnt = 0, start = 0;
        for (int i = 0; i < line.size(); i++) {
            Point p = line.get(i);
            if (board[p.r][p.c] == ccol) {
                if (cnt == 0) start = i;
                cnt++;
            } else {
                if (cnt >= 5) {
                    for (int k = start; k < start + cnt; k++) {
                        Point pp = line.get(k);
                        set.add(pp);
                    }
                }
                cnt = 0;
            }
        }
        if (cnt >= 5) {
            for (int k = start; k < start + cnt; k++) {
                Point pp = line.get(k);
                set.add(pp);
            }
        }
    }

    List<List<Point>> diagDownRight() {
        List<List<Point>> list = new ArrayList<>();
        for (int c = 0; c < W; c++) {
            List<Point> line = new ArrayList<>();
            int r = 0, cc = c;
            while (r < H && cc < W) {
                line.add(new Point(r, cc));
                r++; cc++;
            }
            list.add(line);
        }
        for (int r = 1; r < H; r++) {
            List<Point> line = new ArrayList<>();
            int rr = r, cc = 0;
            while (rr < H && cc < W) {
                line.add(new Point(rr, cc));
                rr++; cc++;
            }
            list.add(line);
        }
        return list;
    }

    List<List<Point>> diagDownLeft() {
        List<List<Point>> list = new ArrayList<>();
        for (int c = 0; c < W; c++) {
            List<Point> line = new ArrayList<>();
            int r = 0, cc = c;
            while (r < H && cc >= 0) {
                line.add(new Point(r, cc));
                r++; cc--;
            }
            list.add(line);
        }
        for (int r = 1; r < H; r++) {
            List<Point> line = new ArrayList<>();
            int rr = r, cc = W - 1;
            while (rr < H && cc >= 0) {
                line.add(new Point(rr, cc));
                rr++; cc--;
            }
            list.add(line);
        }
        return list;
    }

    void flipBlocks(int sr, int sc, int from, int to) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sr, sc));
        board[sr][sc] = to;
        int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int[] x : d) {
                int nr = cur.r + x[0];
                int nc = cur.c + x[1];
                if (nr<0||nr>=H||nc<0||nc>=W) continue;
                if (board[nr][nc] == from) {
                    board[nr][nc] = to;
                    q.offer(new Point(nr, nc));
                }
            }
        }
    }

    void applyGravity() {
        for (int c = 0; c < W; c++) {
            int empty = H - 1;
            for (int r = H - 1; r >= 0; r--) {
                if (board[r][c] != 0) {
                    if (r != empty) {
                        board[empty][c] = board[r][c];
                        board[r][c] = 0;
                    }
                    empty--;
                }
            }
        }
    }

    int findDropRow(int c) {
        for (int r = H - 1; r >= 0; r--) {
            if (board[r][c] == 0) return r;
        }
        return -1;
    }

    int findHighestRow(int c) {
        for (int r = H - 1; r >= 0; r--) {
            if (board[r][c] != 0) return r;
        }
        return -1;
    }

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point)o;
            return r == p.r && c == p.c;
        }
        public int hashCode() {
            return (r * 10000) ^ c;
        }
    }
}