package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC17 {
    public static void main(String[] args) {
        List<List<Integer>> list = pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        for (List<Integer> l : list) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.print(" | ");
        }
        System.out.println();
        list = pacificAtlantic(new int[][]{{1}});
        for (List<Integer> l : list) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.print(" | ");
        }
        System.out.println();
        list = pacificAtlantic(new int[][]{{1,1},{1,1},{1,1}});
        for (List<Integer> l : list) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.print(" | ");
        }
        System.out.println();
    }
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        List<List<Integer>> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++){
            queue.offer(new int[]{i,0});
            visited[i][0] = 1;
        }
        for(int i = 0; i < heights[0].length; i++){
            queue.offer(new int[]{0,i});
            visited[0][i] = 1;
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int k = 0; k < 4; k++){
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];
                if(x<0||y<0||x>=heights.length||y>=heights[0].length|| heights[cur[0]][cur[1]] > heights[x][y] || visited[x][y]!= 0){
                    continue;
                }
                visited[x][y] = 1;
                queue.offer(new int[]{x,y});
            }
        }

        for(int i = 0; i < heights.length; i++){
            queue.offer(new int[]{i,heights[0].length-1});
            visited[i][heights[0].length-1] = visited[i][heights[0].length-1] == 1? 3: 2;
            if (visited[i][heights[0].length-1] == 3){
                list.add(new ArrayList<>(Arrays.asList(i, heights[0].length-1)));
            }
        }
        for(int i = 0; i < heights[0].length; i++){
            queue.offer(new int[]{heights.length-1,i});
            visited[heights.length-1][i] = visited[heights.length-1][i] == 1? 3: 2;
            if (visited[heights.length-1][i] == 3){
                list.add(new ArrayList<>(Arrays.asList(heights.length-1,i)));
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int k = 0; k < 4; k++){
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];
                if(x<0||y<0||x>=heights.length||y>=heights[0].length|| heights[cur[0]][cur[1]] > heights[x][y]||visited[x][y]==2){
                    continue;
                }
                if(visited[x][y]==1){
                    visited[x][y] = 3;
                    list.add(new ArrayList<>(Arrays.asList(x,y)));
                    queue.offer(new int[]{x,y});
                } else if(visited[x][y]==0){
                    visited[x][y] = 2;
                    queue.offer(new int[]{x,y});
                }
            }
        }

        return list;
    }
}
