package java_2023.October;
import java.util.*;
import java.io.*;
public class bj20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> wordPaper = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length()>=M){
                wordPaper.put(word,wordPaper.getOrDefault(word,0)+1);
            }
        }


        List<String> keySet = new ArrayList<>(wordPaper.keySet());
        // 알파벳 사전 순
        Collections.sort(keySet);

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int freqCompare = wordPaper.get(o2).compareTo(wordPaper.get(o1));
                if (freqCompare != 0) {
                    return freqCompare; // 자주 나오는 단어 비교
                }
                int lengthCompare = Integer.compare(o2.length(), o1.length());
                if (lengthCompare != 0) {
                    return lengthCompare; // 단어 길이 비교
                }
                return o1.compareTo(o2); // 알파벳 순 비교
            }
        });

        for (String key : keySet) {
            bw.write(key+"\n");
        }
        bw.flush();
    }
}
