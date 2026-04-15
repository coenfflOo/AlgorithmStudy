package java_2026.April.CosPro;

import java.util.Arrays;

public class pro04 {
    int maxNumber(int value) {
        int[] numbers = new int[4];
        for(int i = 0; i < 4; i++, value/=10)
            numbers[i] = value%10;
        Arrays.sort(numbers);
        int maxNum = 0;
        for(int i = 3; i >= 0; i--)
            maxNum = maxNum * 10 + numbers[i];
        return maxNum;
    }

    int minNumber(int value) {
        int[] numbers = new int[4];
        for(int i = 0; i < 4; i++, value/=10)
            numbers[i] = value%10;
        Arrays.sort(numbers);
        int minNum = 0;
        for(int i = 0; i < 4; i++)
            minNum = minNum*10+numbers[i];
        return minNum;
    }

    public int solution(int num) {
        int answer;
        int maxiNum = maxNumber(num);
        int miniNum = minNumber(num);
        answer = maxiNum - miniNum;
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        pro04 sol = new pro04();
        int num1 = 5924;
        int ret1 = sol.solution(num1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int num2 = 3904;
        int ret2 = sol.solution(num2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
