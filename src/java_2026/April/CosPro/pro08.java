package java_2026.April.CosPro;

public class pro08 {
    public int solution(int numberA, int numberB, int limit) {
        int answer = 0;
        boolean[] visited = new boolean[limit + 1];
        visited[numberA] = true;
        visited[numberB] = true;
        for (int i = 1; i < limit+1; i++) {
            if (visited[i]) {
                int tmp = 1;
                while (i*tmp <= limit) {
                    visited[i*tmp] = true;
                    tmp++;
                }
                for (int j = 0; j < i; j++) {
                    if (visited[j] && j+i <= limit) {
                        visited[j+i] = true;
                    }
                }
            }
        }
        for (int i = 0; i < limit+1; i++) {
            if (visited[i]) {
                answer++;
            }
        }
        return answer;
    }
//    public int solution(int numberA, int numberB, int limit) {
//        int answer = 0;
//        int[] check = new int[1001];
//        check[0] = 1;
//        for(int i = Math.min(numberA, numberB); i <= limit; i++) {
//            if(i - numberA >= 0 && check[i - numberA] == 1)
//                check[i] = 1;
//            if(i - numberB >= 0 && check[i - numberB] == 1)
//                check[i] = 1;
//        }
//        for(int i = 1; i <= limit; i++)
//            answer += check[i];
//        return answer;
//    }

    // 아래는 테스트케이스를 출력해 보기 위한 main 함수입니다.
    public static void main(String[] args) {
        pro08 sol = new pro08();
        int numberA1 = 2;
        int numberB1 = 4;
        int limit1 = 10;
        int ret1 = sol.solution(numberA1, numberB1, limit1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int numberA2 = 2;
        int numberB2 = 3;
        int limit2 = 10;
        int ret2 = sol.solution(numberA2, numberB2, limit2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
