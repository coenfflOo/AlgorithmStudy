package java_2026.April.CosPro;

import java.util.Arrays;

public class pro05 {
    int func_a(int[] arr) {
        int answer = -1;
        for(int i = 0; i < arr.length; i++) {
            if(answer == -1)
                answer = i;
            else if(arr[answer] < arr[i])
                answer = i;
        }
        return answer;
    }

    int[] func_b(String[] arr1, String[] arr2) {
        int[] answer = new int[arr1.length];
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2.length; j++)
                if(arr1[i].equals(arr2[j]))
                    answer[i]++;
        }
        return answer;
    }

    int func_c(int[] arr, int number) {
        int answer = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == number)
                continue;
            if(answer == -1)
                answer = i;
            else if(arr[answer] < arr[i])
                answer=i;
        }
        return answer;
    }
    public String[] solution(String[] menu, String[] votes) {
        int[] counter = func_b(menu, votes);
        int first = func_a(counter);
        int second = func_c(counter, counter[first]);

        String[] answer = new String[2];
        answer[0] = menu[first];
        answer[1] = menu[second];
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
    public static void main(String[] args) {
        pro05 sol = new pro05();
        String[] menuA = {new String("Latte"), new String("Americano"), new String("Espresso")};
        String[] votesA = {new String("Latte"), new String("Americano"), new String("Americano"),
                new String("Latte"), new String("Americano"), new String("Americano"),
                new String("Latte"), new String("Latte"), new String("Latte"), new String("Latte")};
        String[] retA = sol.solution(menuA, votesA);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은" + Arrays.toString(retA) + " 입니다.");

        String[] menuB = {new String("MochaLatte"), new String("GreenTea"), new String("Cappuccino")};
        String[] votesB = {new String("GreenTea"), new String("GreenTea"), new String("MochaLatte"),
                new String("GreenTea"), new String("Cappuccino"), new String("Cappuccino")};
        String[] retB = sol.solution(menuB, votesB);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은" + Arrays.toString(retB) + " 입니다.");
    }

}
