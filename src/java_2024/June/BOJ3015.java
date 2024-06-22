package java_2024.June;

import java.util.*;
import java.io.*;

public class BOJ3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long cnt = 0;
        long high = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (n-- > 0) {
            int h = Integer.parseInt(br.readLine());
            if (stack.isEmpty()) {
                if (high < h) {
                    high = h;
                }
            } else {
                if (stack.peek() > h) {
//                    cur = 1;
                    cnt++;
                } else if (stack.peek() == h) {
//                    if (cur>=stack.size()){
//                        cur = stack.size();
//                        cnt += cur;
//                    } else {
//                        cnt += (++cur);
//                    }
                    cnt += map.get(h);
                    if (map.get(stack.peek()) != stack.size()) {
                        cnt++;
                    }
                } else {
//                    if (high<h){
//                        high=h;
//                        cur = stack.size();
//                        cnt += cur;
//                    } else {
//                        cur = stack.size();
//                        cnt += cur;
//                    }
                    while (!stack.isEmpty() && stack.peek() < h) {
                        map.remove(stack.peek());
                        stack.pop();
                        cnt++;
                    }
                    if (!stack.isEmpty()) {
                        if (stack.peek() > h) {
                            cnt++;
                        } else {
                            cnt += map.get(h);
                            if (map.get(stack.peek()) != stack.size()) {
                                cnt++;
                            }
                        }
                    }
                }
            }
            stack.push(h);
            map.put(h, map.getOrDefault(h, 0) + 1);
//            System.out.println(cnt+" "+stack);
        }
        System.out.println(cnt);
    }
}
// 2 4 1 2 2 5 1
// 0 1 1 2 2 3 1
//

// 8 8 7 7 7 6 6 7 7 7 7 9 9
// 0 1 1 2 3 1 2 6 5 6 7 9 1
//8 0 0
//8 1 1
//8 1 2
//8 2 3
//8 3 4
//8 1 5
//8 2 6
//8 6 7
//8 5 6
//8 6 7
//8 7 8
//9 9 0
//9 1 1

// 7 7 7 6 6 6 7 7 6 6 7 7 6 6 7 7
// 0 1 2 1 2 3 6 4 1 2 7 8 1 2 9 10