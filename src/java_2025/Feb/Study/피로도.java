package java_2025.Feb.Study;

public class 피로도 {
    private static int n, answer;
    private static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        answer = -1;
        fight(k, dungeons, 0);
        return answer;
    }

    private static void fight(int power, int[][] dg, int cnt){
        if(cnt==n){
            answer = Math.max(answer, cnt);
            return;
        }

        for(int i = 0; i<n; i++){
            if(visited[i])
                continue;
            if(dg[i][0]>power || dg[i][1]>power){
                answer = Math.max(answer, cnt);
                continue;
            }
            visited[i] = true;
            fight(power-dg[i][1], dg, cnt+1);
            visited[i] = false;
        }
    }
}
