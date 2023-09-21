import java.util.*;
import java.io.*;
public class bj1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Set<String> word = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            word.add(br.readLine());
        }

        // 중복 제거 후, 단어를 저장한 Set: words
        List<String> sortedWords = new ArrayList<>(word);

        // 길이가 짧은 순서로 정렬, 길이가 같으면 사전 순으로 정렬
        sortedWords.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            } else {
                return s1.compareTo(s2);
            }
        });
        // 정렬된 단어 리스트: sortedWords

        // 결과 출력
        for (String str : sortedWords) {
            bw.write(str+"\n");
        }
        bw.flush();
    }
}
// TreeSet 사용: TreeSet은 원소를 자동으로 정렬하는 특성을 가지고 있습니다.