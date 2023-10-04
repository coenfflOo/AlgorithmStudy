package October;
import java.util.*;
import java.io.*;
public class bj26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> dance = new HashSet<>();
        dance.add("ChongChong");
        for (int i = 0; i < N; i++) {
            String[] people = br.readLine().split(" ");
            if (dance.contains(people[0]) || dance.contains(people[1])) {
                dance.add(people[1]);
                dance.add(people[0]);
            }
        }
        bw.write(String.valueOf(dance.size()));
        bw.close();
    }
}
