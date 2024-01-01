package java_2023.September;
import java.util.*;
import java.io.*;
public class bj7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> people = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] record = br.readLine().split(" ");
            if (!people.contains(record[0]) ||  record[1].equals("enter"))
                people.add(record[0]);
            else
                people.remove(record[0]);
        }

        ArrayList<String> names = new ArrayList<>(people);
        names.sort(Collections.reverseOrder());
        for (String name :
                names) {
            System.out.println(name);
        }
    }
}
