import java.util.*;
import java.io.*;
public class bj2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        // 카드 초기화
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        // 카드를 뽑아내고 옮기는 작업 반복
        while (queue.size() > 1) {
            queue.poll(); // 제일 위의 카드를 버림
            int topCard = queue.poll(); // 제일 위의 카드를 뽑아냄
            queue.offer(topCard); // 뽑아낸 카드를 아래로 옮김
        }

        bw.write(String.valueOf(queue.poll())); // 마지막으로 남은 카드 출력
        bw.flush();
    }
}
// 큐(Queue)는 데이터를 선입선출(First-In-First-Out, FIFO)의 순서로 저장하고 관리하는 자료 구조입니다.
// 가장 많이 사용되는 큐의 메서드들은 다음과 같습니다:
//
//offer(E e):
//
//큐에 원소를 추가합니다.
//큐가 가득 차면 false를 반환하며, 성공적으로 원소를 추가하면 true를 반환합니다.
//
//poll():
//
//큐에서 가장 앞에 있는 원소를 제거하고 반환합니다.
//큐가 비어있으면 null을 반환합니다.
//
//peek():
//
//큐에서 가장 앞에 있는 원소를 제거하지 않고 반환합니다.
//큐가 비어있으면 null을 반환합니다.
//
//element():
//
//큐에서 가장 앞에 있는 원소를 제거하지 않고 반환합니다.
//큐가 비어있으면 NoSuchElementException을 발생시킵니다.
//
//remove(Object o):
//
//큐에서 특정 원소를 찾아서 제거합니다.
//원소를 찾아서 제거하면 true를 반환하며, 원소가 없으면 false를 반환합니다.
//
//isEmpty():
//
//큐가 비어있는지 여부를 확인합니다.
//큐가 비어있으면 true를 반환하고, 원소가 하나라도 있으면 false를 반환합니다.
//
//size():
//
//큐에 저장된 원소의 개수를 반환합니다.
//
//clear():
//
//큐의 모든 원소를 제거하여 비웁니다.
//
//이러한 메서드들은 큐를 다룰 때 기본적으로 사용되며, 큐의 종류에 따라 추가적인 메서드나 기능이 제공될 수 있습니다.
// Java에서는 java.util.Queue 인터페이스를 구현한 다양한 큐 클래스가 제공되며, 필요에 따라 선택하여 사용할 수 있습니다.
// 가장 일반적으로 사용되는 큐 구현체로는 LinkedList나 ArrayDeque가 있습니다.