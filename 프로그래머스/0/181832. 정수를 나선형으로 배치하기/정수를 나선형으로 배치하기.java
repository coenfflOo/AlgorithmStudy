class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        boolean flag = true;
        int nx = 0;
        int ny = 0;
        int index = 1;
        int k=0;
        while(flag){
            flag=false;
            out: while(!(nx<0||ny<0||nx>=n||ny>=n)&&answer[nx][ny]==0){
                answer[nx][ny] = index++;
                nx += dx[k];
                ny += dy[k];
                flag = true;
            }
            nx -= dx[k];
            ny -= dy[k];
            if(k==3) k=0;
            else k++;
            nx += dx[k];
            ny += dy[k];
        }
        return answer;
    }
}