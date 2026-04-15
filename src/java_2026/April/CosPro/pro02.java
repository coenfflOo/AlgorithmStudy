package java_2026.April.CosPro;

public class pro02 {
    public String solution(int money, int[][] cost, String[] name) {
        String answer = null;
        long max_distance = 0;

        for (int i = 0; i < cost.length; i++){
            int oil = money / cost[i][1];
            long distance = oil * cost[i][0];
            if (distance > max_distance) {
                max_distance = distance;
                answer = name[i];
            }
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
    public static void main(String[] args) {
        int money = 100000;
        int[][] cost = {{50, 5000}, {20, 1000}, {20, 5000}, {50, 1000}};
        String[] name = { "A", "B", "C", "D" };
        pro02 sol = new pro02();
        String ret = sol.solution(money, cost, name);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
