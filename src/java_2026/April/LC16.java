package java_2026.April;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC16 {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0}}));
        System.out.println(canFinish(2, new int[][]{{1,0},{0,1}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] cur = prerequisites[i];
            indegree[cur[0]]++;
            graph.get(cur[1]).add(cur[0]);
        }
        boolean[] visited = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
