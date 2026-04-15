package java_2026.April.CosPro;

import java.util.Arrays;

public class pro01 {

    public int[][] func_a(int[][] arr) {
        int[][] ret = new int[arr.length][arr[0].length-2];
        for(int i = 0; i < arr.length; i++) {
            Arrays.sort(arr[i]);
            for(int j=1; j < arr[i].length-1; j++) {
                ret[i][j-1] = arr[i][j];
            }
        }
        return ret;
    }

    public int func_b(int[][] arr) {
        int[] ret = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
        		ret[i] += arr[i][j];
            }
            ret[i] = ret[i] / arr[i].length;
        }
        Arrays.sort(ret);
        return ret[ret.length - 1];
    }


    public int solution(int[][] scores) {
        int[][] arr2 = func_a(scores);
        int answer = func_b(arr2);
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
    public static void main(String[] args) {
        pro01 sol = new pro01();
        int[][] scores = {{85, 92, 95, 90}, {91, 76, 85, 50}};
        int ret = sol.solution(scores);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }

}
