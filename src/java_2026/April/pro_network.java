package java_2026.April;
import java.util.*;

public class pro_network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; // 각 컴퓨터 방문 여부 (0~n-1)

        for(int i=0; i<n; i++){
            if(!visited[i]){      // 아직 어떤 네트워크에도 속하지 않은 컴퓨터 발견
                answer++;         // 새로운 네트워크 발견
                bfs(i, n, computers, visited); // 해당 컴퓨터와 연결된 모든 컴퓨터 방문 처리
            }
        }
        return answer;
    }

    private void bfs(int start, int n, int[][] computers, boolean[] visited){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true; // 시작 컴퓨터 방문 처리

        while(!q.isEmpty()){
            int cur = q.poll(); // 현재 탐색할 컴퓨터

            // cur 컴퓨터와 연결된 모든 컴퓨터 확인
            // computers[cur][j] == 1 이면 cur과 j가 연결되어 있음 (인접 행렬)
            for(int j=0; j<n; j++){
                if(computers[cur][j] == 1 && !visited[j]){ // 연결되어 있고 아직 미방문이면
                    visited[j] = true; // 방문 처리 (중복 탐색 방지)
                    q.offer(j);        // 큐에 추가해서 이후에 탐색
                }
            }
        }
    }
}