package java_2026.April.CosPro;

import java.util.Arrays;
import java.util.Comparator;

public class pro03 {
    public int[] solution(int[][] projects) {
        Arrays.sort(projects, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] != b[1]) return b[1] - a[1];
                if(a[2] != b[2]) return b[2] - a[2];
                return a[0]-b[0];
            }
        });

        int[] answer = new int[projects.length];
        for(int i = 0; i < projects.length; i++)
            answer[i] = projects[i][0];
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        pro03 sol = new pro03();
        int[][] projects = {{5, 90, 90}, {1, 90, 70}, {3, 95, 70}, {2, 85, 85}, {4, 70, 90}};
        int[] ret = sol.solution(projects);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
    }
}
