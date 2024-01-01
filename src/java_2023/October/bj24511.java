package java_2023.October;
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

        int N = Integer.parseInt(br.readLine()); // N: 자료구조의 개수

        int[] typeArr = new int[N]; // 각 자료구조의 타입(0: 큐, 1: 스택)을 저장하는 배열

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 각 자료구조의 타입 정보를 입력받아 typeArr에 저장
        for (int i = 0; i < N; i++) {
            typeArr[i] = Integer.parseInt(st.nextToken());
        }
        
        Deque<Integer> deque = new ArrayDeque<>(); // 원소를 저장하기 위한 Deque 자료구조

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 현재 자료구조가 큐인 경우 뒤에 원소를 삽입
            if (typeArr[i] == 0) {
                deque.addLast(num);
            }
        }

        int M = Integer.parseInt(br.readLine()); // M: 삽입할 원소의 개수

        st = new StringTokenizer(br.readLine());
        br.close();

        // 원소를 삽입하고 리턴값을 구하는 과정을 반복
        while (M --> 0) { // M을 하나씩 감소하며 반복
            int moveValue = Integer.parseInt(st.nextToken()); // 삽입할 원소

            deque.addFirst(moveValue); // 현재 자료구조에 원소를 삽입
            sb.append(deque.pollLast()).append(" "); // 마지막 자료구조에서 원소를 빼고 결과 문자열에 추가
        }

        System.out.println(sb); // 결과 문자열 출력
    }
}
