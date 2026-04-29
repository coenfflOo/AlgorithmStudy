package java_2026.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC21 {
    public static void main(String[] args) {
        for (int[] arr : merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})) {
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();
        for (int[] arr : merge(new int[][]{{1, 4}, {4, 5}})) {
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();
        for (int[] arr : merge(new int[][]{{4, 7}, {1, 4}})) {
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();
    }

    //    public static int[][] merge(int[][] intervals) {
//        List<int[]> res = new ArrayList<>();
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//        int n = intervals.length;
//        int i = 0;
//        int start = intervals[0][0];
//        int end = intervals[0][1];
//        while (i < n) {
//            while (i<n&&end >= intervals[i][0]){
//                end = Math.max(end, intervals[i][1]);
//                i++;
//            }
//            res.add(new int[]{start, end});
//            if (i<n){
//                start = intervals[i][0];
//                end = intervals[i][1];
//            }
//        }
//        return res.toArray(new int[res.size()][]);
//    }
    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));

        // 첫 구간을 현재 구간으로 설정하고 결과에 미리 추가
        // current는 결과 리스트의 마지막 구간을 참조함
        int[] current = intervals[0];
        ans.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                // 겹치면 current[1]을 직접 업데이트
                // current가 ans의 마지막 요소를 참조하고 있으므로
                // ans 안의 값도 자동으로 바뀜! (같은 배열 참조)
                current[1] = Math.max(interval[1], current[1]);
            } else {
                // 안 겹치면 새 구간을 current로 설정하고 추가
                current = interval;
                ans.add(interval);
            }
        }

        return ans.toArray(new int[0][]);
    }
}
