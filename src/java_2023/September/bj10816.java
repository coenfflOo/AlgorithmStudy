import java.util.*;
import java.io.*;
public class bj10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] arrN = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arrN);

        int M = Integer.parseInt(br.readLine());
        long[] arrM = new long[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Long.parseLong(st2.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int result = countOccurrences(arrN, arrM[i]);
            bw.write(result+" ");
        }

        bw.flush();

    }

    public static int countOccurrences(long[] arr, long target) {
        int firstOccurrence = findFirstOccurrence(arr, target);
        if (firstOccurrence == -1) {
            // 원하는 요소가 배열에 없는 경우
            return 0;
        }

        int lastOccurrence = findLastOccurrence(arr, target);
        return lastOccurrence - firstOccurrence + 1;
    }

    public static int findFirstOccurrence(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;
        int firstOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                firstOccurrence = mid;
                right = mid - 1; // 왼쪽 부분 탐색
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstOccurrence;
    }

    public static int findLastOccurrence(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;
        int lastOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                lastOccurrence = mid;
                left = mid + 1; // 오른쪽 부분 탐색
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastOccurrence;
    }
}
