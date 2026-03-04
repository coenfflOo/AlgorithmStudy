package java_2026.Jan;
import java.util.*;
import java.io.*;
public class BOJ15665 {
    static int N,M;
    static int[] arr, number;
    static List<Integer> list;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        number = new int[M];
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (list.contains(num)) continue;
            list.add(num);
        }
        arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        sb = new StringBuilder();
        findArr(0);
        System.out.println(sb.toString());
    }

    private static void findArr(int select) {
        if (select == M) {
            for(int num: number) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            number[select] = arr[i];
            findArr(select+1);
        }
    }
}
