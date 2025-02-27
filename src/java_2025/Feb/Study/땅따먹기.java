package java_2025.Feb.Study;

public class 땅따먹기 {
    static int solution(int[][] land) {
        int[][] yum = new int[land.length][4];

        for (int i = 0; i < 4; i++) {
            yum[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                for(int k = 0; k<4; k++){
                    if(j != k){
                        yum[i][j] = Math.max(yum[i][j],yum[i-1][k]+land[i][j]);
                    }
                }
            }
        }

        int sum = 0;
        for(int i=0;i<4;i++){
            sum = Math.max(sum, yum[land.length-1][i]);
        }
        return sum;
    }
}
