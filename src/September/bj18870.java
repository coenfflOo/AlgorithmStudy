package September;

import java.util.*;
import java.io.*;

public class bj18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = arr.clone();
        arr = Arrays.stream(arr).distinct().toArray();
        Arrays.sort(arr);
        for (int number :
                result) {
            bw.write(findIndex(number, arr) + " ");
        }
        bw.close();
    }

    private static int findIndex(int n, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == n) {
                return mid; // 원하는 요소를 찾은 경우 해당 인덱스를 반환
            } else if (arr[mid] < n) {
                left = mid + 1; // 중간 값보다 큰 경우 오른쪽 반을 탐색
            } else {
                right = mid - 1; // 중간 값보다 작은 경우 왼쪽 반을 탐색
            }
        }
        return -1;
    }
}