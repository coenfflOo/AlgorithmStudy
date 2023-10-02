package October;
//import java.util.*;
//import java.io.*;
//public class bj24511 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        int[] structure = new int[N]; // 0: Queue, 1: Stack
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            structure[i] = Integer.parseInt(st.nextToken());
//        }
//
//        List<Integer> elements = new ArrayList<>(); // 각 자료구조에 들어있는 원소
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            elements.add(Integer.parseInt(st.nextToken()));
//        }
//
//        StringBuilder sb = new StringBuilder();
//        int M = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < M; i++) {
//            int c = Integer.parseInt(st.nextToken());
//
//            for (int j = 0; j < N; j++) {
//                if (structure[j] == 0) { // Queue
//                    int e = elements.get(j);
//                    elements.set(j, c);
//                    c=e;
//                } else if (structure[j] == 1){ // Stack
//                    if (j==N-1)
//                        elements.add(c);
//                }
//            }
//
//            sb.append(c).append(" ");
//            if (elements.size()>N)
//                elements.remove(elements.size()-1);
//        }
//        System.out.println(sb);
//    }
//}

import java.util.*;
import java.io.*;

public class bj24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] typeArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            typeArr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(typeArr[i] == 0){
                deque.addLast(num);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        br.close();
        while(M --> 0){
            int moveValue = Integer.parseInt(st.nextToken());
            deque.addFirst(moveValue);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}
