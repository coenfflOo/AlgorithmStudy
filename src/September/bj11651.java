package September;
import java.util.*;
import java.io.*;
public class bj11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] point = new String[N];
        for (int i = 0; i < N; i++) {
            point[i] = br.readLine();
        }

        Arrays.sort(point, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String[] split1 = s1.split(" ");
                String[] split2 = s2.split(" ");
                int age1 = Integer.parseInt(split1[1]);
                int age2 = Integer.parseInt(split2[1]);

                if (age1 == age2)
                    return Integer.compare(Integer.parseInt(split1[0]),Integer.parseInt(split2[0]));
                else
                    return Integer.compare(age1, age2);
            }
        });

        for (String str :
                point) {
            bw.write(str+"\n");
        }
        bw.flush();
    }
}
