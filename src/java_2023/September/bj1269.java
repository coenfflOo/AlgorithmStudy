package java_2023.September;
import java.util.*;
import java.io.*;

public class bj1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            setA.add(Integer.parseInt(st2.nextToken()));
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            setB.add(Integer.parseInt(st3.nextToken()));
        }

        // 교집합의 개수 구하기
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);

        int result = A - intersection.size() + B - intersection.size();
        System.out.println(result);
    }
}
// 두 개의 집합(Set)을 사용하여 중복된 요소를 자동으로 제거하고,
// retainAll 메서드를 사용하여 두 집합의 교집합을 구합니다.
// 그런 다음 교집합의 크기를 이용하여 공통되지 않는 요소의 개수를 계산합니다.
// 이 방법은 시간 복잡도를 효율적으로 줄일 수 있습니다.