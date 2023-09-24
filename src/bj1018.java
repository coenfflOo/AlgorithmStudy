import java.util.*;
import java.io.*;
public class bj1018 {
    public static int getSolution(int startRow, int startCol, String[] board) {
        String[] orgBoard = { "WBWBWBWB", "BWBWBWBW" }; // white체스판과 비교 (black 체스판과 비교해도 상관없음)
        int whiteSol = 0;
        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                // board라는 변수에 담겨있는 값과 orgBoard라는 정답지와 비교
                // 정답지를 두줄만 만들었기 때문에 row를 그대로 쓰면 문제 발생 (%2 값 사용)
                // 8칸만 만들었기 떄문에 col까지 가면 범위가 벗어날수있음 (j 사용)
                if (board[row].charAt(col) != orgBoard[row % 2].charAt(j)) {
                    // 자른 체스판과 정답지가 같은지 다른지 계산 후 다르다면 하나를 더 칠해야 함
                    whiteSol++;
                }
            }
        }
        // 화이트 체스판 만들기 위한 최솟값 = 64(전체 값) - 검정색 체스판 만들기 위한 최솟값
        return Math.min(whiteSol, 64 - whiteSol);
    }

    public static void main(String[] args) throws IOException{
        // 0. input 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        // 체스판의 값 받아오기
        String[] board = new String[row];
        for (int i = 0; i < row; i++) board[i] = br.readLine();

        // 1. 체스판 자르기
        int sol = Integer.MAX_VALUE;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                // 각각 i와 j번째에 위치한 지점부터 8x8 체스판이 잘림
                // 2. 현 체스판의 최소 비용 구하기
                int curSol = getSolution(i, j, board);
                // 3. 전체 최적의 값과 비교하여 갱신하기
                if (sol > curSol) sol = curSol;
            }
        }

        bw.write(String.valueOf(sol));
        bw.flush();
    }
}
