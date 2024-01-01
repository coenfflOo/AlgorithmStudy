import java.util.*;
import java.io.*;
//개어려워..map이랑 set에 대해서 개념정리 필요
public class bj1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        s = s.toUpperCase();

        Map<String, Integer> alphabet = new HashMap<>();
        for (String word : s.split("")) {
            int pValue = alphabet.getOrDefault(word, 0);
            alphabet.put(word, pValue + 1);
        }

        int[] arr = alphabet.values().stream().mapToInt(Integer::intValue).toArray();
        int max = 0;
        String answer ="";
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i])
                answer = "?";
            else if (max<arr[i]){
                max = arr[i];
                for(String key : alphabet.keySet()) {
                    // 키와 매핑된 값이랑 equals() 메서드에 전달된 값이랑 일치하면 반복문을 종료합니다.
                    if(alphabet.get(key).equals(max)) { // 키가 null이면 NullPointerException 예외 발생
                        answer = key;
                        break;
                    }
                }
            }
        }
        bw.write(answer);
        bw.flush();

    }
}
