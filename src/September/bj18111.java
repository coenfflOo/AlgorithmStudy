package September;
import java.util.*;
import java.io.*;
public class bj18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] ground = new int[N][M];

        int min = 256;
        int max = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if(min > ground[i][j]) min = ground[i][j];
                if(max < ground[i][j]) max = ground[i][j];
            }
        }

        //time은 최소시간을 저장 할 변수, 풀이에 적었듯이
        //올 수 있는 값은 6400만정도로 예상 되기에 넉넉히 9999만을 저장.
        int time = 99999999;
        int high = 0;

        //만틀 층 i
        for(int i = min; i <= max; i++) {
            int countTime = 0;
            int inventoryBlock = B;
            //좌표 j와 k
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    //현재 좌표의 층이 만들 층보다 높으면 제거하는데, 블록은 제거한 만큼 추가, 시간은 두배로
                    if(i < ground[j][k]) {
                        countTime += ((ground[j][k] - i) * 2);
                        inventoryBlock += (ground[j][k] - i);
                        //낮을 경우 블록은 제거, 시간은 1배
                    }else {
                        countTime += (i - ground[j][k]);
                        inventoryBlock -= (i - ground[j][k]);
                    }
                }
            }
            //블록의 개수가 음수가 되면 반복문 종료
            if(inventoryBlock < 0) break;

            if(time >= countTime) {
                time = countTime;
                high = i;
            }
        }
        System.out.println(time + " " + high);
    }
}