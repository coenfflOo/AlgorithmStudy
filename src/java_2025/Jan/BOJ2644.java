package java_2025.Jan;

import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2644 {
    static int n;
    static ArrayList<ArrayList<Integer>> relation;
    static Queue<Integer> queue;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        relation = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            relation.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relation.get(x).add(y);
            relation.get(y).add(x);
        }

        queue = new ArrayDeque<>();
        visited = new boolean[n+1];

//        System.out.println(bfs(a,b));
//        System.out.println(dfs(a,b));
        dfs(a,b,0);
        System.out.println("-1");
    }

    private static int bfs(int a, int b){
        visited[a] = true;
        for(int num: relation.get(a)){
            queue.offer(num);
            visited[num] = true;
        }

        int cnt = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int people = queue.poll();

                if(people == b)
                    return cnt;
                else {
                    for(int num: relation.get(people)){
                        if(visited[num])
                            continue;
                        queue.offer(num);
                        visited[num] = true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    private static void dfs(int a, int b,int count){
//       System.out.println(a+" "+b+" "+count);
        if(a==b) {
            System.out.println(count);
            exit(0);
        }
//        if(relation.get(a).size()<=index)
//            return -1;

        visited[a] = true;
//        System.out.print(Arrays.toString(visited));
//        System.out.println(a+":"+count+"-> ");
        for(int i=0;i<relation.get(a).size();i++) {
            int num = relation.get(a).get(i);
            if(!visited[num]) {
                visited[num] = true;
                dfs(num,b,count+1);
            }
        }
//        int num = relation.get(a).get(index);
//        if(!visited[num]){
//            visited[num] = true;
//            return 1+ dfs(num,b,index);
//        }
//        return dfs(a,b,index+1);
    }
}
