package java_2025.Mar.Study;
import java.util.Stack;
public class 괄호_회전하기 {
    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
            }
            if (i != 0){
                for (int j = 0; j < i; j++) {
                    sb.append(s.charAt(j));
                }
            }

            Stack<Character> st = new Stack<>();
            for (char c : sb.toString().toCharArray()) {
                if (!st.isEmpty() && st.peek() == '(' && c == ')') {
                    st.pop();
                } else if (!st.isEmpty() && st.peek() == '{' && c == '}') {
                    st.pop();
                } else if (!st.isEmpty() && st.peek() == '[' && c == ']') {
                    st.pop();
                } else {
                    st.push(c);
                }
            }
            if (st.isEmpty())
                answer++;
        }
        return answer;
    }
}
