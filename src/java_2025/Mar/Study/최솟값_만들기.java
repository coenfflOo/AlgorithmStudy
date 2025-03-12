package java_2025.Mar.Study;

import java.util.Arrays;

public class 최솟값_만들기 {
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int j = B.length-1;
        for(int i=0; i<A.length; i++){
            answer += A[i]*B[j--];
        }
        return answer;
    }
}
