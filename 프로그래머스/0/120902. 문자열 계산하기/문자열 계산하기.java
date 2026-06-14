import java.util.*;
class Solution {
    public int solution(String my_string) {
        String[] str = my_string.split(" ");
        int num = Integer.parseInt(str[0]);
        int index = 2;
        int op = 1;
        while(index < str.length){
            switch(str[op]){
                case "+":
                    num += Integer.parseInt(str[index]);
                    break;
                case "-":
                    num -= Integer.parseInt(str[index]);
                    break;
            }
            op += 2;
            index += 2;
        }
        return num;
    }
}