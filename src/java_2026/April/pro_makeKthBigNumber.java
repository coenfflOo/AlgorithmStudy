package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class pro_makeKthBigNumber {
    public String solution(int[] numbers, int k) {
        int n = numbers.length;

        // 숫자 배열을 문자열 배열로 변환
        String[] str = new String[n];
        for(int i=0; i<n; i++){
            str[i] = String.valueOf(numbers[i]);
        }

        // 가장 큰 수 기준으로 내림차순 정렬
        // ex) [3, 30, 34] → ["34", "3", "30"]
        Arrays.sort(str, (s1, s2) -> {
            if(Long.parseLong(s1+s2) > Long.parseLong(s2+s1)) return -1;
            else return 1;
        });

        // 팩토리얼 미리 계산
        // ex) factorial[3] = 6, factorial[2] = 2, factorial[1] = 1
        long[] factorial = new long[n+1];
        factorial[0] = 1;
        for(int i=1; i<=n; i++) factorial[i] = factorial[i-1] * i;

        // 후보 리스트 (정렬된 상태)
        List<String> candidates = new ArrayList<>(Arrays.asList(str));
        String answer = "";
        k--; // 0-indexed로 변환 (3번째 → index 2)

        // 앞자리부터 하나씩 결정
        for(int i=n; i>=1; i--){
            long cnt = factorial[i-1]; // 현재 숫자 선택 시 남은 경우의 수
            int idx = (int)(k / cnt);  // 몇 번째 후보를 선택할지
            answer += candidates.get(idx); // 선택한 숫자 추가
            candidates.remove(idx);        // 선택한 숫자 후보에서 제거
            k %= cnt;                      // K 갱신
        }

        return answer;
    }
}
