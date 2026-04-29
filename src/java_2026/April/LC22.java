package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;

public class LC22 {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));
    }

//    public static int eraseOverlapIntervals(int[][] intervals) {
//        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
//        ArrayList<int[]> res = new ArrayList<>();
//        int ans = 0;
//        int[] current = intervals[0];
//        res.add(current);
//        for(int[] interval : intervals) {
//            if (interval[0] < current[1]) {
//                current[1] = Math.min(interval[1], current[1]);
//                ans++;
//            } else {
//                current = interval;
//                res.add(current);
//            }
//        }
//        return ans-1; // 첫 구간도 ans++에 포함돼서 ans-1
//    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]); // end 기준 정렬 ← 핵심 차이!
        int end = intervals[0][1];
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < end){
                // 겹치면 → 제거 카운트
                // end는 그대로 유지 (이미 end가 작은 순으로 정렬됐으니까)
                count++;
            } else {
                // 안겹치면 → end 업데이트
                end = intervals[i][1];
            }
        }
        return count;
    }
}
