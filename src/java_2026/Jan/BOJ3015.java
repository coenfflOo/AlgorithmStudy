package java_2026.Jan;
import  java.io.*;
import java.util.*;
public class BOJ3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<People> stack = new ArrayDeque<>();
        long ans = 0;

        for(int i = 0; i < N; i++){
            int height = Integer.parseInt(br.readLine()); // 키
            int cnt = 1; // 같은 키가 연속/묶여서 압축된 사람 수

            while(!stack.isEmpty()&&stack.peek().height < height){
                // 새로 들어온 사람 키보다 작은 키 전부 뺌
                ans += stack.pop().cnt;
            }

            // 나보다 크거나 같은 사람만 스택에 남음
            if(!stack.isEmpty()&&stack.peek().height == height){
                // 같은 키는 압축해서 다시 저장
                ans += stack.peek().cnt;
                cnt += stack.peek().cnt;
                stack.pop();
                // 같은 키 뒤에 더 큰 사람이 있으면 그 사람까지 보임 (큰 같 같 같 같)
                if(!stack.isEmpty()) ans++;
            } else { // 나보다 큰 키만 스택에 남음. 난 큰 사람 한명만 볼 수 있음
                if(!stack.isEmpty()) ans++;
            }
            stack.push(new People(height, cnt));
        }
        System.out.println(ans);
    }

    static class People {
        int height;
        int cnt;
        public People(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }
}