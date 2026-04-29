package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;

public class LC20 {
    public static void main(String[] args) {
        for (int[] arr: insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})){
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();
        for (int[] arr: insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})){
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();
        for (int[] arr: insert(new int[][]{{1,5}}, new int[]{2,3})){
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();
        for (int[] arr: insert(new int[][]{{1,5}}, new int[]{6,8})){
            System.out.print(Arrays.toString(arr));
        }
        System.out.println();
        for (int[] arr: insert(new int[][]{{1,3},{6,9}}, new int[]{4,5})){
            System.out.print(Arrays.toString(arr));
        }
    }

//    public static int[][] insert(int[][] intervals, int[] newInterval) {
//        int ns = newInterval[0];
//        int ne = newInterval[1];
//        List<int[]> res = new ArrayList<>();
//        if (intervals.length == 0){
//            res.add(newInterval);
//            return res.toArray(new int[res.size()][]);
//        }
//        boolean flag = false;
//        boolean used = false;
//        for (int i = 0; i < intervals.length; i++) {
//            int[] cur = intervals[i];
//            if (!( ne < cur[0] || ns > cur[1])){
//                ns = Math.min(cur[0], ns);
//                ne = Math.max(cur[1], ne);
//                flag = true;
//                used = true;
//            } else {
//                if (flag){
//                    res.add(new int[]{ns, ne});
//                    flag = false;
//                }
//                res.add(cur);
//            }
//        }
//        if (flag){
//            res.add(new int[]{ns, ne});
//        }
//        if (!used){
//            res.add(new int[]{ns, ne});
//        }
//        res.sort(Comparator.comparingInt(a -> a[0]));
//        return res.toArray(new int[res.size()][]);
//    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Phase A: newInterval보다 완전히 왼쪽에 있는 구간들
        // intervals가 이미 정렬되어 있으니까 end < newInterval.start 이면
        // 절대 겹칠 일 없음 → 그냥 바로 추가
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Phase B: newInterval과 겹치는 구간들을 전부 newInterval로 흡수
        // start <= newInterval.end 이면 겹친다는 뜻
        // newInterval 자체를 업데이트해나가면서 합침
        // → 루프 끝나면 newInterval이 최종 합쳐진 구간
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // 합쳐진 구간 한 번만 추가

        // Phase C: newInterval보다 완전히 오른쪽에 있는 구간들
        // 이미 정렬되어 있으니 나머지 전부 그냥 추가
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[0][]);
    }
}
