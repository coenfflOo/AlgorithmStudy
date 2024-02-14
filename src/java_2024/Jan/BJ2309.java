package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> people = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            people.add(Integer.parseInt(br.readLine()));
            sum += people.get(i);
        }
        Collections.sort(people);

        for (int i = 0; i < people.size(); i++) {
            for (int j = i+1; j < people.size(); j++) {
                if (sum - people.get(i) - people.get(j) == 100 && people.size() == 9){
                    people.remove(i);
                    people.remove(j-1);
                    break;
                }
            }
        }

        for (int height:
             people) {
            bw.write(height +"\n");
        }
        bw.flush();
    }
}
