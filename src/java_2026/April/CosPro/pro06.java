package java_2026.April.CosPro;

public class pro06 {
    public int solution(int start, int[] locations) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i : locations) {
            if(i < min) min = i;
            if(i > max) max = i;
        }

        if(start <= min)
            answer = max - start;
        else if(start >= max)
            answer = start - min;
        else {
            if(start - min < max - start)
                answer = start - min + (max - min);
            else
                answer = max - start + (max - min);
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. 아래에는 잘못된 부분이 없으니, 위의 코드만 수정하세요.
    public static void main(String[] args) {
        pro06 sol = new pro06();
        int start = 15;
        int[] locations = {10, 62, 22};
        int ret = sol.solution(start, locations);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
