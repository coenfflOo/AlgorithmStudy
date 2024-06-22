package java_2024.Mar;
import java.util.*;
import java.io.*;
public class SWEA1263 {

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[][] people = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    people[i][j] = sc.nextInt();
                }
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int tmp = 0;
                int[] visited = new int[n];
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);

                while (!queue.isEmpty()){
                    int x = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if(i==j) continue;
                        if (visited[j] != 0 || people[x][j]==0) continue;
                        visited[j] = visited[x]+1;
                        tmp += visited[j];
                        queue.offer(j);
                    }
                }
                if (min>tmp) min = tmp;
//                System.out.println(tmp);
//                System.out.println(Arrays.toString(visited));

            }
            System.out.println("#"+test_case+" "+min);
        }
    }
}
