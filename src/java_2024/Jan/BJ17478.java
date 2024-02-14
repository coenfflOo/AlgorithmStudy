package java_2024.Jan;

import java.io.*;

public class BJ17478 {
    static int N = 0;
    static String[] str = {"\"재귀함수가 뭔가요?\"", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        whatIsRecursiveFunction(N, sb);
        System.out.println(sb);
    }

    private static void whatIsRecursiveFunction(int n, StringBuilder sb) {
        if (n == 0) {
            sb.append("____".repeat(Math.max(0, N - n)));
            sb.append(str[n]).append("\n");
            sb.append("____".repeat(Math.max(0, N - n)));
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
        } else {
            for (int i = 0; i < str.length; i++) {
                sb.append("____".repeat(Math.max(0, N - n)));
                sb.append(str[i]).append("\n");
            }
            whatIsRecursiveFunction(n - 1, sb);
        }
        sb.append("____".repeat(Math.max(0, N - n)));
        sb.append("라고 답변하였지.").append("\n");
    }
}