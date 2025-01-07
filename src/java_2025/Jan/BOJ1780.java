package java_2025.Jan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1780 {
    private static int[] count;
    private static int[][] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken())+1;
            }
        }

        count = new int[3];
        findPaper(0,0, n);
        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }

    private static void findPaper(int col, int row, int size){
        if (colorCheck(row, col, size)){
            count[graph[row][col]]++;
        } else {
            int newSize = size / 3;

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    findPaper(col + i * newSize, row + j * newSize, newSize);
                }
            }
        }
    }

    private static boolean colorCheck(int row, int col, int size) {
        int color = graph[row][col];

        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if (graph[i][j] != color)
                    return false;
            }
        }
        return true;
    }
}
