package java_2025.May;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] crane = new Integer[n];
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(crane,Comparator.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if (boxes.getFirst()>crane[0]) {
            System.out.println("-1");
            return;
        }
        int minutes = 0;
        while (!boxes.isEmpty()) {
            int b = 0;
            int c = 0;

            while (c<n){
                if (b==boxes.size()) break;
                else if (crane[c]>=boxes.get(b)) {
                    boxes.remove(b);
                    c++;
                } else b++;
            }
            minutes++;
        }
        System.out.println(minutes);
    }
}
