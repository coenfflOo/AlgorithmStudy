package java_2025.Mar;
import java.util.*;
import java.lang.*;
import java.io.*;
public class BOJ9019 {
    private static final String[] op = {"D","S","L","R"};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc<t; tc++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int result = Integer.parseInt(st.nextToken());
            bfs(cur, result);
        }
    }

    private static void bfs(int cur, int result){
        Queue<Number> queue = new ArrayDeque<>();
        queue.offer(new Number(cur, new StringBuilder()));
        boolean[] visited = new boolean[10000];
        visited[cur] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Number num = queue.poll();
                int c = num.number;
                for(int k=0; k<4; k++){
                    int nc = calculate(c,op[k]);
                    if(visited[nc]) continue;
                    visited[nc] = true;
                    StringBuilder nsb = new StringBuilder();
                    nsb.append(num.sb).append(op[k]);
                    if(nc==result){
                        System.out.println(nsb);
                        return;
                    }
                    queue.offer(new Number(nc, nsb));
                }
            }
        }
    }

    private static int calculate(int c, String operation){
        int n;
        switch(operation){
            case "D":
                return c*2>9999?(c*2)%10000:c*2;
            case "S":
                if(c==0) return 9999;
                else return c-1;
            case "L":
                n = c/1000;
                return (c-1000*n)*10+n;
            case "R":
                n = c%10;
                return (c-n)/10+n*1000;
        }
        return -1;
    }

    static class Number{
        int number;
        StringBuilder sb;
        public Number(int n, StringBuilder sb){
            this.number = n;
            this.sb =sb;
        }
    }
}
