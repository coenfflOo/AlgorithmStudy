package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class pro_diskController {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        // 1. jobs를 요청시각 순으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        // 2. 현재 시각 = 0
        int current = 0;
        int index = 0;
        int total = 0;
        // 3. 현재 시각 이하인 작업을 전부 PQ에 넣기
        while(index<jobs.length || !pq.isEmpty()){
            while(index<jobs.length && jobs[index][0]<=current){
                int[] job = jobs[index];
                Job cur = new Job(job[0], job[1], index);
                pq.offer(cur);
                index++;
            }
            if(!pq.isEmpty()){
                // 4. PQ에서 우선순위 높은 작업 꺼내서 실행
                Job job = pq.poll();
                // 5. 현재 시각 += 소요시간 (작업 끝나는 시점으로 점프)
                current += job.time;
                total += (current - job.in);
            } else current = jobs[index][0];
        }
        return total/jobs.length;
    }

    static class Job implements Comparable<Job>{
        int in;
        int time;
        int num;
        public Job(int in, int time, int num){
            this.in = in;
            this.time = time;
            this.num = num;
        }

        @Override
        public int compareTo(Job o){
            if(this.time != o.time) return this.time - o.time;  // 소요시간 오름차순
            if(this.in != o.in) return this.in - o.in;          // 요청시각 오름차순
            return this.num - o.num;                             // 번호 오름차순
        }
    }
}
