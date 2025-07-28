package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> col = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        col.add(0);
        row.add(0);
        col.add(Integer.parseInt(st.nextToken()));
        row.add(Integer.parseInt(st.nextToken()));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())){
                case 0:
                    row.add(Integer.parseInt(st.nextToken()));
                    break;
                case 1:
                    col.add(Integer.parseInt(st.nextToken()));
                    break;
            }
        }

        Collections.sort(col);
        Collections.sort(row);

        int c = col.get(1) - col.get(0);
        for (int i = 2; i < col.size(); i++) {
            c = Math.max(c, col.get(i)-col.get(i-1));
        }

        int r = row.get(1) - row.get(0);
        for (int i = 2; i < row.size(); i++) {
            r = Math.max(r, row.get(i)-row.get(i-1));
        }
        System.out.println(c*r);
    }
}
