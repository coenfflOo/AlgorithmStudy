package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class pro_findItem {
    static String[][] shape;
    static int startX, startY, targetX, targetY, answer, total;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        shape = new String[52][52];
        startX = characterX; startY = characterY;
        targetX = itemX; targetY = itemY;
        answer = total = 0;

        // shape 배열 빈 문자열로 초기화
        for(int i=0; i<52; i++) Arrays.fill(shape[i], "");

        for(int[] xy : rectangle){
            int leftX = xy[0], rightX = xy[2], leftY = xy[1], rightY = xy[3];

            // 네 꼭짓점 표시
            // LUX = Left Up   (왼쪽 위),   RUX = Right Up   (오른쪽 위)
            // LDX = Left Down (왼쪽 아래), RDX = Right Down (오른쪽 아래)
            shape[leftX][leftY]   = "LDX";
            shape[rightX][leftY]  = "RDX";
            shape[leftX][rightY]  = "LUX";
            shape[rightX][rightY] = "RUX";

            // 위(U) 변과 아래(D) 변 표시 (x를 좌→우로 순회)
            // 직사각형이 겹치면 += 로 문자열이 합쳐짐 (예: "U" + "L" = "UL")
            for(int x = leftX+1; x < rightX; x++){
                shape[x][rightY] += "U"; // 위변
                shape[x][leftY]  += "D"; // 아래변
            }

            // 왼(L) 변과 오른(R) 변 표시 (y를 아래→위로 순회)
            for(int y = leftY+1; y < rightY; y++){
                shape[leftX][y]  += "L"; // 왼변
                shape[rightX][y] += "R"; // 오른변
            }
        }

        // 출발점에서 테두리를 한 방향으로 순회 시작
        followLine(characterX, characterY);

        // 한 바퀴 전체 둘레 = total
        // 한 방향으로 간 거리 = answer
        // 반대 방향으로 간 거리 = total - answer
        // 둘 중 짧은 것이 정답
        return Math.min(answer, total - answer);
    }

    public void followLine(int x, int y){
        String location = shape[x][y];

        // 현재 위치의 shape 문자열을 보고 다음 이동 방향 결정
        // 위변(U) 위에 있으면 → x 증가 (오른쪽으로)
        if(location.equals("RU") || location.equals("UR") || location.equals("LUX") || location.equals("U"))  x++;
        // 아래변(D) 위에 있으면 → x 감소 (왼쪽으로)
        if(location.equals("LD") || location.equals("DL") || location.equals("RDX") || location.equals("D"))  x--;
        // 왼변(L) 위에 있으면 → y 증가 (위로)
        if(location.equals("LU") || location.equals("UL") || location.equals("LDX") || location.equals("L"))  y++;
        // 오른변(R) 위에 있으면 → y 감소 (아래로)
        if(location.equals("RD") || location.equals("DR") || location.equals("RUX") || location.equals("R"))  y--;

        // 한 칸 이동했으므로 총 이동거리 +1
        total++;

        // 아이템 위치에 도달했으면 현재까지의 거리를 기록
        if(x == targetX && y == targetY) answer = total;
        // 출발점으로 돌아왔으면 한 바퀴 완료 → 종료
        if(x == startX && y == startY)   return;

        // 다음 칸으로 재귀 호출
        followLine(x, y);
    }
}
