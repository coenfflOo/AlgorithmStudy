package java_2025.Feb.Study;

public class 숫자의_표현 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i<=n; i++){
            if(check(i, n)){
                answer++;
            }
        }
        return answer;
    }

    private static boolean check(int num, int goal){
        int sum = 0;
        for(int i=num; i<=goal; i++){
            sum += i;
            if(sum==goal)
                return true;
            else if(sum>goal)
                return false;
        }
        return false;
    }
}
