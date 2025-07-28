package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =  br.readLine();
        int n = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }
        for (int i = 0; i < n; i++) {
            String order = br.readLine();
            char c = order.charAt(0);
            switch (c){
                case 'L':
                    if(iter.hasPrevious())
                        iter.previous();
                    break;
                case 'D':
                    if(iter.hasNext()){
                        iter.next();
                    }
                    break;
                case 'B':
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char t = order.charAt(2);
                    iter.add(t);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character l : list){
            sb.append(l);
        }
        System.out.print(sb);
    }
}
