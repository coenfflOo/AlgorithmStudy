class Solution {
    public int solution(String before, String after) {
        int[] alphabet = new int[26];
        for(int i=0; i<before.length(); i++){
            alphabet[before.charAt(i)-'a']++;
            alphabet[after.charAt(i)-'a']--;
        }
        int answer = 1;
        for(int i=0; i<26; i++){
            if(alphabet[i] != 0) answer = 0;
        }
        return answer;
    }
}