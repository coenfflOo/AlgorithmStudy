package java_2026.Jan;

import java.util.*;
import java.io.*;

public class BOJ5397 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int tc = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        while(tc-->0){
//            LinkedList<String> arr = new LinkedList<>();
//            String[] str = br.readLine().split("");
//            int index = 0;
//            for(String s: str){
//                if(s.equals("<")){
//                    index = index == 0? 0: index-1;
//                } else if(s.equals(">")){
//                    index = index == arr.size()? index: index+1;
//                } else if(s.equals("-")){
//                    if(!arr.isEmpty()) {
//                        if (index == 0) continue;
//                        arr.remove(index-1);
//                        index--;
//                    }
//                } else {
//                    arr.add(index,s);
//                    index++;
//                }

    /// /                System.out.println(Arrays.toString(arr.toArray()));
//            }
//            for(String s: arr){
//                sb.append(s);
//            }
//            sb.append('\n');
//        }
//        System.out.println(sb);
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            Stack<String> stack = new Stack<>();
            String[] str = br.readLine().split("");
            int index = 0;
            for(String s: str){
                if(s.equals("<")){
                    index = index == 0? 0: index-1;
                } else if(s.equals(">")){
                    index = index == stack.size()? index: index+1;
                } else if(s.equals("-")){
                    if(!stack.isEmpty()) {
                        if (index == 0) continue;
                        stack.remove(index-1);
                        index--;
                    }
                } else {
                    stack.push(s);
                    index++;
                }
            }
            for(String s: stack){
                sb.append(s);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
