package java_2024.June;
import java.util.*;
import java.io.*;
public class BOJ1245 {
    static int n,m,cnt;
    static boolean flag;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,1,1,0,0,-1,-1,-1};
    static int[] dy = {-1,0,1,1,-1,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];

        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flag = true;
                if(!visited[i][j]){
                    bfsArr(i,j);
//                    printArr();
                    if(flag){
                        cnt++;
                    }
//                    System.out.println(cnt);
                }
            }
        }
        System.out.println(cnt);
    }

    private static void bfsArr(int i, int j) {
        visited[i][j] = true;
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i,j));

        while (!queue.isEmpty()){
            int size = queue.size();
//            System.out.println(height);
            while (size-->0){
                Point p = queue.poll();

//                System.out.println(p);
                for (int k = 0; k < 8; k++) {
                    int ni = p.i+dx[k];
                    int nj = p.j+dy[k];

                    if(ni<0||nj<0||ni>=n||nj>=m) {
                        continue;
                    }

                    if (arr[p.i][p.j]==arr[ni][nj]){
                        if (visited[ni][nj])
                            continue;
                        visited[ni][nj]=true;
                        queue.offer(new Point(ni,nj));
                    } else if (arr[p.i][p.j]<arr[ni][nj]){
                        flag = false;
                    }
                }
            }
        }
    }

//    private static boolean isPossible(int i, int j) {
//        for (int k = 0; k < 8; k++) {
//            int nx = i+dx[k];
//            int ny = j+dy[k];
//            if(nx<0||ny<0||nx>=n||ny>=m)
//                continue;
//            if(arr[i][j]<arr[nx][ny])
//                return false;
//        }
//        return true;
//    }

//    static void printArr(){
//        System.out.println("=====================================");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (visited[i][j]) {
//                    System.out.print("O ");
//                } else {
//                    System.out.print("X ");
//                }
//            }
//            System.out.println();
//        }
//        System.out.println("=====================================");
//    }
    static class Point{
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

//        @Override
//        public String toString() {
//            return "Point{" +
//                    "i=" + i +
//                    ", j=" + j +
//                    '}';
//        }
    }
}
