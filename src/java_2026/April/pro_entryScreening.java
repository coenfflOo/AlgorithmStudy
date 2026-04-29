package java_2026.April;

public class pro_entryScreening {
    public long solution(int n, int[] times) {
        int minTime = Integer.MAX_VALUE;
        for(int t: times) minTime = Math.min(minTime,t);

        long left = 1;
        // 가장 빠른 심사관(minTime)이 n명을 혼자 처리하는 시간이 상한선
        long right = (long) minTime * n;
        long answer = right;

        // left == right인 마지막 케이스까지 확인해야함
        while(left<=right){
            long mid = (left+right)/2;

            // total = 각 심사관별 (mid / times[i]) 의 합
            long total = 0;
            for(int t : times){
                total += mid/(long)t;
            }

            // total >= n 이면?  → answer 갱신, 범위를 왼쪽으로
            // total < n  이면?  → 범위를 오른쪽으로
            if(total >= n){
                answer = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return answer;
    }
}
