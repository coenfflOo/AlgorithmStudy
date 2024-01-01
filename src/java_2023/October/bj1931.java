package java_2023.October;

import java.util.*;
import java.io.*;

public class bj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        // 종료 시간을 기준으로 오름차순 정렬
        Collections.sort(meetings);

        int count = 0;
        int endTime = 0;

        for (Meeting meeting : meetings) {
            if (meeting.start >= endTime) {
                // 현재 회의의 시작 시간이 이전 회의 종료 시간 이후라면 회의실을 사용
                count++;
                endTime = meeting.end;
            }
        }

        /**
         * 리스트 출력 확인
        for (Meeting meeting : meetings) {
            System.out.println("Start: " + meeting.start + ", End: " + meeting.end);
        }
         */


        System.out.println(count);
    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 종료 시간을 기준으로 정렬
        @Override
        public int compareTo(Meeting other) {
            if (this.end == other.end) {
                // 종료 시간이 같다면 시작 시간으로 비교
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }
}
