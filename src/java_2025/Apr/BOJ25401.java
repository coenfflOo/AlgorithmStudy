package java_2025.Apr;
import java.util.*;
import java.io.*;
public class BOJ25401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            map.put(cards[i], map.getOrDefault(cards[i], 0)+1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        int change = n - entryList.get(map.size()-1).getValue();

        int[] arr = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int h = i+1; h < n; h++) {
                int abs = (cards[h] - cards[i])/(h-i);
                int cnt = 0;
                arr[i] = cards[i];
                for (int j = i; j < n-1; j++) {
                    arr[j+1] = arr[j]+abs;
                    if (arr[j+1] != cards[j+1]) cnt++;
                }
                for (int j = i; j > 0; j--) {
                    arr[j-1] = arr[j] - abs;
                    if (arr[j-1] != cards[j-1]) cnt++;
                }
                change = Math.min(change, cnt);
            }
        }
        System.out.println(change);
    }
}
