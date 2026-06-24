import java.util.*;
class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder(phone_number);
        answer.replace(0,phone_number.length()-4,"*".repeat(phone_number.length()-4));
        return answer.toString();
    }
}