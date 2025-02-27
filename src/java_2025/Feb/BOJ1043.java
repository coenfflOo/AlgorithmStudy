package java_2025.Feb;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.exit;

public class BOJ1043 {
    private static int[] root;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        root = new int[n+1];
        set(n);

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> truth = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            truth.add(Integer.parseInt(st.nextToken()));
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);

            for (int j = 1; j < party.size(); j++) {
                union(party.get(0), party.get(j));
            }
        }

        if(k==0){
            System.out.println(m);
            exit(0);
        }

        int answer = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                for (int tPerson : truth) {
                    if (find(person) == find(tPerson)) {
                        canLie = false;
                        break;
                    }
                }
                if (!canLie) break;
            }
            if (canLie) answer++;
        }

        System.out.println(answer);
    }

    private static void set(int n) {
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (root[a] < root[b]) {
            root[b] = a;
        } else {
            root[a] = b;
        }
    }

    private static int find(int a) {
        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}
