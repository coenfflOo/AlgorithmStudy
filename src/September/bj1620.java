package September;
import java.util.*;
import java.io.*;

public class bj1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> pocketmonMap = new HashMap<>();
        List<String> pocketmonList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String pocketmon = br.readLine();
            pocketmonMap.put(pocketmon, i + 1); // 포켓몬 이름을 키(key)로 사용하여 인덱스를 저장
            pocketmonList.add(pocketmon);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (isInt(str)) {
                // 입력이 숫자인 경우
                int index = Integer.parseInt(str);
                sb.append(pocketmonList.get(index - 1));
            } else {
                // 입력이 문자열인 경우
                sb.append(pocketmonMap.get(str));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isInt(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}

// 시간 복잡도를 줄이려면 pocketmon 리스트에 저장된 포켓몬의 이름을 키(key)로 가지고 있는 해시맵(HashMap)을 사용하여 포켓몬 이름을 조회하는 방법을 사용
// 이렇게 하면 포켓몬 이름을 조회할 때 리스트를 순회하는 것보다 효율적
// 포켓몬 이름을 pocketmonMap 해시맵에 저장하여 포켓몬 이름을 키로 사용하고, 인덱스를 값으로 저장