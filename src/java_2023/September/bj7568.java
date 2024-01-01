package java_2023.September;
import java.io.*;

class Person {
    int weight;
    int height;

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}

public class bj7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            people[i] = new Person(weight, height);
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (people[i].weight < people[j].weight && people[i].height < people[j].height) {
                    rank++;
                }
            }

            bw.write(rank + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
