package java_2026.April.CosPro;

import java.util.ArrayList;
import java.util.Arrays;

public class pro07 {
    int ALPHANUM = 26;

    void func1(int number, boolean[][] arr1, boolean[] arr2) {
        arr2[number] = true;
        for(int i = 0; i < ALPHANUM; i++)
            if(arr1[number][i] && !arr2[i])
                func1(i, arr1, arr2);
    }

    int func2(boolean[] arr) {
        int answer = 0;
        for(int i = 0; i < ALPHANUM; i++)
            if(arr[i])
                answer++;
        return answer;
    }

    void func3(String[] arr1, boolean[][] arr2) {
        for(int i = 0; i < arr1.length; i++) {
            int num1 = arr1[i].charAt(0) - 'A';
            int num2 = arr1[i].charAt(1) - 'A';
            arr2[num1][num2] = true;
            arr2[num2][num1] = true;
        }
    }

    int solution(String[] list) {
        boolean[][] graph = new boolean[ALPHANUM][ALPHANUM];
        boolean[] visited = new boolean[ALPHANUM];

        func3(list, graph);
        visited[0] = true;
        for(int node = 0; node < ALPHANUM; node++)
            if(graph[0][node] && !visited[node])
                func1(node, graph, visited);
        return func2(visited);
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        pro07 sol = new pro07();
        String[] list = {new String("AB"), new String("BC"), new String("DE"), new String("CF")};
        int ret = sol.solution(list);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
