package September;
import java.util.*;
import java.io.*;
public class bj1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> people = new HashMap<>();
        for (int i = 0; i < (N+M); i++) {
            String name = br.readLine();
            if (!people.containsKey(name)) {
                int value = people.getOrDefault(name, 0);
                people.put(name, value + 1);
            } else {
                people.put(name, people.get(name)+1);
            }
        }

        ArrayList<String> names = new ArrayList<>(people.keySet());
        Collections.sort(names);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String name: names){
            if (people.get(name)==2) {
                count++;
                sb.append(name).append("\n");
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
