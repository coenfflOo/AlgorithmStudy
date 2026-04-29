package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class pro_ranking {
    public int solution(int n, int[][] results) {
        // win[i][j] = true : i가 j를 이김
        // lose[i][j] = true : i가 j에게 짐
        boolean[][] win = new boolean[n+1][n+1];
        boolean[][] lose = new boolean[n+1][n+1];

        // 주어진 경기 결과 입력
        // r[0]이 r[1]을 이겼으므로, r[1] 입장에선 r[0]에게 진 것
        for(int[] r: results){
            win[r[0]][r[1]] = true;
            lose[r[1]][r[0]] = true;
        }

        // 각 선수(i)마다 BFS로 간접 관계 전파
        for(int i=1; i<=n; i++){

            // [이긴 방향 전파]
            // ex) i→A→B 이면, i는 B도 이김 → win[i][B] = true
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            queue.offer(i);
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int j=1; j<=n; j++){
                    // cur이 j를 이긴 적 있고, 아직 방문 안했으면
                    if(win[cur][j] && !visited[j]){
                        visited[j] = true;
                        win[i][j] = true; // i도 j를 이길 수 있음
                        queue.offer(j);
                    }
                }
            }

            // [진 방향 전파]
            // ex) i→A→B 이면 (i가 A에게 지고, A가 B에게 짐)
            // i는 B에게도 짐 → lose[i][B] = true
            queue = new ArrayDeque<>();
            visited = new boolean[n+1];
            visited[i] = true;
            queue.offer(i);
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int j=1; j<=n; j++){
                    // cur이 j에게 진 적 있고, 아직 방문 안했으면
                    if(lose[cur][j] && !visited[j]){
                        visited[j] = true;
                        lose[i][j] = true; // i도 j에게 짐
                        queue.offer(j);
                    }
                }
            }
        }

        // 순위 확정 선수 카운트
        int answer = 0;
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=n; j++){
                // i가 j를 이겼거나, i가 j에게 진 관계가 밝혀진 경우
                if(win[i][j] || lose[i][j]) count++;
            }
            // 나머지 n-1명과의 관계가 모두 밝혀져야 순위 확정
            if(count == n-1) answer++;
        }
        return answer;
    }
}
