package java_2026.April;

public class LC30 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
    public static boolean isAnagram(String s, String t) {
        int[] letters = new int[26];
        for(char c : s.toCharArray()){
            letters[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            letters[c - 'a']--;
            if (letters[c - 'a'] < 0) return false;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) return false;
        }
        return true;
    }
}
