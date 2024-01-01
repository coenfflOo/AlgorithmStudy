import java.io.*;
import java.util.*;

public class bj10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] members = new String[N];

        for (int i = 0; i < N; i++) {
            members[i] = br.readLine();
        }

        Arrays.sort(members, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String[] split1 = s1.split(" ");
                String[] split2 = s2.split(" ");
                int age1 = Integer.parseInt(split1[0]);
                int age2 = Integer.parseInt(split2[0]);

                return Integer.compare(age1, age2);
            }
        });

        for (String member : members) {
            bw.write(member + "\n");
        }

        bw.flush();
    }
}
