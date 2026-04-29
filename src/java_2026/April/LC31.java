package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC31 {
    public static void main(String[] args) {
        for(List<String> list : groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"})){
            System.out.print(list+" - ");
        }
        System.out.println();
        for(List<String> list : groupAnagrams(new String[]{""})){
            System.out.print(list+" ");
        }
        System.out.println();
        for(List<String> list : groupAnagrams(new String[]{"a"})){
            System.out.print(list+" ");
        }
        System.out.println();
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            int index;
            if (!map.containsKey(key)) {
                map.put(key, ans.size());
                ans.add(new ArrayList<>());
            }
            index = map.get(key);
            ans.get(index).add(s);
        }
        return ans;
    }
}
