package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class pro_makeBigNumber {
    public String solution(int[] numbers) {
        // 숫자 배열을 문자열 배열로 변환
        // ex) [3, 30, 34] → ["3", "30", "34"]
        // 문자열로 변환하는 이유: 숫자를 이어붙여 비교하기 위해
        String[] str = new String[numbers.length];
        boolean zero = true; // 모든 숫자가 0인지 체크 (ex. [0,0,0] → "0" 반환용)

        for(int i=0; i<numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
            if(numbers[i] != 0) zero = false; // 0이 아닌 숫자가 하나라도 있으면 false
        }

        // 핵심 로직: 두 문자열을 이어붙인 결과로 내림차순 정렬
        // ex) "3"과 "30" 비교 → "330" vs "303" → "330"이 크므로 "3"이 앞으로
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                // s1+s2 vs s2+s1 을 숫자로 변환해 비교
                // s1+s2가 더 크면 s1이 앞에 와야 하므로 -1 반환 (내림차순)
                if(Integer.parseInt(s1+s2) > Integer.parseInt(s2+s1)) return -1;
                    // s1+s2가 더 작으면 s2가 앞에 와야 하므로 1 반환
                else if(Integer.parseInt(s1+s2) < Integer.parseInt(s2+s1)) return 1;
                    // 같으면 순서 무관
                else return 0;
            }
        });

        // 정렬된 문자열 배열을 하나로 합치기
        // ex) ["3", "30", "34"] 정렬 후 → ["34", "3", "30"] → "34330"
        String answer = "";
        for(int i = 0; i < str.length; i++)
            answer += str[i];

        // 모든 숫자가 0이면 "000...0" 대신 "0" 반환
        // ex) [0, 0, 0] → "0"
        if(zero) answer = "0";
        return answer;
    }
}
