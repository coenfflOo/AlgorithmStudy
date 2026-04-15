package java_2026.April.CosPro;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class pro09 {
    int find(int x, int[] adj) {
        if(adj[x] == x) return x;
        return find(adj[x], adj);
    }

    public void union(int a, int b, int[] adj) {
        a = find(a, adj);
        b = find(b, adj);
        if(a != b) adj[b] = a;
    }

    public int solution(int N, int[][] info, int[][] game) {
        int result=0;

        int[] adj = new int[N];

        for (int i = 1; i < N; i++) {
            adj[i] = i;
        }

        for (int i = 0; i < game.length; i++) {
            int first = game[i][0];
            for (int j = 1; j < game[i].length; j++) {
                union(first, game[i][j], adj);
            }
        }

        for(int i=0; i<game.length; i++) {
            boolean isChecked = true;
            int cur = game[i][0];
            for(int j=0; j <info[1].length; j++) {
                if(find(cur, adj) == find(info[1][j], adj)) {
                    isChecked = false;
                    break;
                }
            }
            if(isChecked) result++;
        }

        int answer = result;
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
    public static void main(String[] args) {

        pro09 sol = new pro09();
        int N = 5;
        int[][] info = { { 1 }, { 4 } };
        int[][] game = { { 1,2 }, {3}, { 3, 4 } };
        int ret = sol.solution(N, info, game);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");


        int N2 = 7;
        int[][] info2 = { { 3 }, { 1, 2, 3 } };
        int[][] game2 = {{1}, {2}, {3}, {4}, {5}, {6}, {4, 5}, {3, 6}};
        int ret2 = sol.solution(N2, info2, game2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
