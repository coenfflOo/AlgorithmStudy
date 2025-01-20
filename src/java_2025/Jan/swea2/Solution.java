package java_2025.Jan.swea2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
	private static final int INIT = 100;
	private static final int DROP_BLOCKS = 200;
	private static final int CHANGE_BLOCKS = 300;
	private static final int GET_RESULT = 400;

	private static UserSolution usersolution = new UserSolution();

	private static boolean run(BufferedReader br) throws Exception {
		int Q = Integer.parseInt(br.readLine());
		int W, H, mPlayer, mCol, ret = -1, ans;
		int[] mBlockCnt = new int[2];
		int r1, r2;
		boolean okay = false;

		for (int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int cmd = Integer.parseInt(st.nextToken());
			switch (cmd) {
				case INIT:
					W = Integer.parseInt(st.nextToken());
					H = Integer.parseInt(st.nextToken());
					usersolution.init(W, H);
					okay = true;
					break;
				case DROP_BLOCKS:
					mPlayer = Integer.parseInt(st.nextToken());
					mCol = Integer.parseInt(st.nextToken());
					if (okay) ret = usersolution.dropBlocks(mPlayer, mCol);
					ans = Integer.parseInt(st.nextToken());
					if (ret != ans) okay = false;
					break;
				case CHANGE_BLOCKS:
					mPlayer = Integer.parseInt(st.nextToken());
					mCol = Integer.parseInt(st.nextToken());
					if (okay) ret = usersolution.changeBlocks(mPlayer, mCol);
					ans = Integer.parseInt(st.nextToken());
					if (ret != ans) okay = false;
					break;
				case GET_RESULT:
					if (okay) ret = usersolution.getResult(mBlockCnt);
					ans = Integer.parseInt(st.nextToken());
					r1 = Integer.parseInt(st.nextToken());
					r2 = Integer.parseInt(st.nextToken());
					System.out.println("Expected: ans=" + ans + ", r1=" + r1 + ", r2=" + r2);
					System.out.println("Actual: ret=" + ret + ", mBlockCnt[0]=" + mBlockCnt[0] + ", mBlockCnt[1]=" + mBlockCnt[1]);
					if (ans != ret || mBlockCnt[0] != r1 || mBlockCnt[1] != r2) okay = false;
					break;
				default:
					okay = false;
					break;
			}
		}
		return okay;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int TC = Integer.parseInt(line.nextToken());
		int MARK = Integer.parseInt(line.nextToken());
		for (int t = 1; t <= TC; t++) {
			int score = run(br) ? MARK : 0;
			System.out.println("#" + t + " " + score);
		}
		br.close();
	}
}