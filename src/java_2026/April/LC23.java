package java_2026.April;

import java.util.*;
import java.io.*;
import java.lang.*;

public class LC23 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
        System.out.println("========================");
        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

    //    public static void setZeroes(int[][] matrix) {
//        List<Integer> col = new ArrayList<>();
//        List<Integer> row = new ArrayList<>();
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[i].length; j++){
//                if(matrix[i][j] == 0){
//                    if (!col.contains(i)) col.add(i);
//                    if (!row.contains(j)) row.add(j);
//                }
//            }
//        }
//        for(int c : col){
//            Arrays.fill(matrix[c], 0);
//        }
//        for(int r : row){
//            for (int i = 0; i < matrix.length; i++) {
//                matrix[i][r] = 0;
//            }
//        }
//    }
    public static void setZeroes(int[][] matrix) {
        int i, j, col0 = 1, m = matrix.length, n = matrix[0].length;

        // Phase 1: 0인 원소를 찾아서 첫 행/첫 열에 마킹
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // i행을 0으로 만들어야 한다고 첫 열에 마킹
                    if (j != 0) {
                        matrix[0][j] = 0; // j열을 0으로 만들어야 한다고 첫 행에 마킹
                    } else {
                        col0 = 0; // j==0이면 첫 열 자체가 0이 되어야 함
                        // 근데 첫 열은 마커로 쓰고 있어서 따로 col0으로 기록!
                    }
                }
            }
        }

        // Phase 2: 첫 행/첫 열 마커를 보고 1행 1열부터 0으로 채우기
        // (0행 0열은 마커라서 나중에 따로 처리!)
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // Phase 3: 첫 행(0행) 처리
        // matrix[0][0]이 0이면 첫 행 전체를 0으로
        if (matrix[0][0] == 0) {
            for (j = 0; j < n; j++)
                matrix[0][j] = 0;
        }

        // Phase 4: 첫 열(0열) 처리
        // col0이 0이면 첫 열 전체를 0으로
        if (col0 == 0) {
            for (i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }
}
