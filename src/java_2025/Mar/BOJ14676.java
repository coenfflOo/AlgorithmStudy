package java_2025.Mar;

import java.io.*;
import java.util.*;

public class BOJ14676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 건물 종류 개수
        int m = Integer.parseInt(st.nextToken());  // 건물 사이 관계 개수
        int k = Integer.parseInt(st.nextToken());  // 영우의 게임 정보 개수

        List<Integer>[] graph = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];  // 선행 건물 개수 저장
        int[] builtCount = new int[n + 1];  // 현재 건설된 건물 개수 저장

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        // 건물 관계 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            indegree[y]++;  // y 건물을 짓기 위해 필요한 선행 건물 개수 증가
        }

        // 영우의 게임 진행
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int action = Integer.parseInt(st.nextToken());
            int building = Integer.parseInt(st.nextToken());

            if (action == 1) {  // 건설
                if (indegree[building] > 0) {  // 필요한 선행 건물이 다 지어지지 않은 경우
                    System.out.println("Lier!");
                    return;
                }
                builtCount[building]++;  // 건물 추가
                if (builtCount[building] == 1) {  // 최초 건설 시, 영향을 받는 건물들의 선행 개수 감소
                    for (int next : graph[building]) {
                        indegree[next]--;
                    }
                }
            } else {  // 파괴
                if (builtCount[building] == 0) {  // 지어진 적 없는 건물을 파괴하려는 경우
                    System.out.println("Lier!");
                    return;
                }
                builtCount[building]--;  // 건물 개수 감소
                if (builtCount[building] == 0) {  // 마지막 건물을 파괴했을 경우, 영향을 받은 건물 복구
                    for (int next : graph[building]) {
                        indegree[next]++;
                    }
                }
            }
        }
        System.out.println("King-God-Emperor");
    }
}
