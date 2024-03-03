package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ17952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Stack<Project> projects = new Stack<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (Objects.equals(st.nextToken(), "0")) {
                if (!projects.isEmpty()) {
                    Project p = projects.pop();
                    if (p.minutes - 1 != 0) {
                        projects.push(new Project(p.score, p.minutes - 1));
                    } else {
                        sum += p.score;
                    }
                }
            } else {
                int a = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken()) - 1;
                if (t != 0) {
                    projects.push(new Project(a, t));
                } else {
                    sum += a;
                }
            }
        }
        System.out.println(sum);
    }

    static class Project {
        int score;
        int minutes;

        public Project(int score, int minutes) {
            this.score = score;
            this.minutes = minutes;
        }
    }
}
