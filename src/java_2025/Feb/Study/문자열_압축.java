package java_2025.Feb.Study;

import java.util.*;
class 문자열_압축 {
    public int solution(String s) {
        int len = s.length();
        int size = 1;
        int answer = 1000;
        while(size<=len){
            int check=0;
            int total =0;
            Stack<String> stack = new Stack<>();
            for(int i=0; i<len; i=i+size){
                if(i+size>len){
                    total += (len-i);
                    continue;
                }

                String sub = s.substring(i,i+size);
                if(stack.isEmpty()){
                    stack.push(sub);
                    check++;
                } else {
                    if(stack.peek().equals(sub)){
                        check++;
                    } else {
                        int cnt = 0;
                        if(check!=1){
                            while(check>0){
                                check /= 10;
                                cnt++;
                            }
                            total += cnt;
                        }
                        check = 1;
                        stack.push(sub);
                    }
                }
            }
            int cnt = 0;
            if(check!=1){
                while(check>0){
                    check /= 10;
                    cnt++;
                }
                total += cnt;
            }
            total += stack.size()*size;
            if(total<answer)
                answer = total;
            size++;
        }
        return answer;
    }
}