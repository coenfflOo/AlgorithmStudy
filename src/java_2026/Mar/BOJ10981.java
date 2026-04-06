package java_2026.Mar;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ10981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<University> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String univ = st.nextToken();
            String team = st.nextToken();
            int solution = Integer.parseInt(st.nextToken());
            int penalty = Integer.parseInt(st.nextToken());
            pq.offer(new University(univ, team, solution, penalty));
        }

        Set<String> visited = new HashSet<>();
        int count = 0;
        while (!pq.isEmpty() && count < K) {
            University u = pq.poll();
            if (!visited.contains(u.university)) {
                visited.add(u.university);
                System.out.println(u.team);
                count++;
            }
        }
    }

    static class University implements Comparable<University> {
        String university;
        String team;
        int solution;
        int penalty;

        public University(String university, String team, int solution, int penalty) {
            this.university = university;
            this.team = team;
            this.solution = solution;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(University o) {
            if (this.solution != o.solution) return o.solution - this.solution;
            return this.penalty - o.penalty;
        }

        @Override
        public String toString() {
            return university + "-" + team + "-" + solution + "-" + penalty;
        }
    }
}
