package java_2025.Apr.study;
import java.io.*;
import java.util.*;

public class BOJ1599 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] alpha = "a b k d e g h i l m n ng o p r s t u w y".split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(alpha));
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            public int compare(String s1, String s2) {
                int indexA = 0;
                int indexB = 0;
                while (indexA < s1.length() && indexB < s2.length()) {
                    String a;
                    String b;

                    if (indexA < s1.length()-1 && s1.charAt(indexA) == 'n' && s1.charAt(indexA+1) == 'g') {
                        a = "ng";
                        indexA+=2;
                    } else {
                        a = s1.substring(indexA, indexA+1);
                        indexA++;
                    }

                    if (indexB < s2.length()-1 && s2.charAt(indexB) == 'n' && s2.charAt(indexB+1) == 'g') {
                        b = "ng";
                        indexB+=2;
                    } else {
                        b = s2.substring(indexB, indexB+1);
                        indexB++;
                    }


                    if (!a.equals(b)) {
                        return list.indexOf(a) - list.indexOf(b);
                    }
                }
                return s1.length() - s2.length();
            }
        });

        for (int i = 0; i < n; i++) {
            pq.offer(br.readLine());
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
