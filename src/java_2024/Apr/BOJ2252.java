package java_2024.Apr;

import java.util.*;
import java.io.*;

public class BOJ2252 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 학생 수만큼 인접 리스트 초기화하기
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        // 진입 차수 배열 초기화하기
        int[] indgree = new int[n + 1];
        // 데이터 입력 받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            indgree[b]++;
        }

        // 큐 생성하기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            // 진입 차수 배열의 값이 0인 학생(노드)을 큐에 삽입하기
            if (indgree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            // 현재 노드에서 갈 수 있는 노드의 개수만큼 반복
            for (int next : list.get(now)) {
                // 타켓 노드 집입 차수 배열 --
                indgree[next]--;
                // 타벡 노드의 집입 차수가 0이면
                if (indgree[next] == 0) {
                    // 큐에 타깃 노드 추가하기
                    queue.offer(next);
                }
            }
        }
    }
}
