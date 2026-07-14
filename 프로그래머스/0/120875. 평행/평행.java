import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        for(int i=1; i<4; i++){
            List<Double> list = new ArrayList<>();
            boolean[] impossible = new boolean[4];
            double slope = (double)(Math.abs(dots[0][0]-dots[i][0]))/Math.abs(dots[0][1]-dots[i][1]);
            list.add(slope);
            impossible[0] = true;
            impossible[i] = true;
            for(int j=0; j<4; j++){
                if(impossible[j]) continue;
                for(int k=j+1; k<4; k++){
                    if(impossible[k]) continue;
                    slope = (double)(Math.abs(dots[j][0]-dots[k][0]))/Math.abs(dots[j][1]-dots[k][1]);
                    if(list.contains(slope)) {
                            return 1;
                    }
                }
            }
        }
        return 0;
    }
}