package java_2026.April;

import java.util.HashSet;
import java.util.Set;

public class LC47 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        // 노드 생성
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        // 연결
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // pos=1 → 인덱스 1번(node1)으로 연결!

        System.out.println(hasCycle(node0)); // true
    }

    // 플로이드 사이클 감지 알고리즘 (토끼와 거북이)
    // 사이클 없으면 → fast가 먼저 null 도달
    // 사이클 있으면 → 원형 트랙에서 빠른 토끼가
    //                느린 거북이를 결국 따라잡음!
    //
    // 마치 육상트랙에서
    // 빠른 선수가 느린 선수를 한바퀴 앞서는 것처럼 😊
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        // slow = 거북이 (1칸씩 이동)
        // fast = 토끼 (2칸씩 이동)
        ListNode slow = head;
        ListNode fast = head;

        // fast나 fast.next가 null이면 사이클 없음
        // (끝까지 갔다는 뜻)
        while (fast != null && fast.next != null) {
            slow = slow.next;       // 1칸 이동
            fast = fast.next.next;  // 2칸 이동

            // 사이클이 있으면 토끼가 거북이를 따라잡음!
            if (slow == fast) return true;
        }
        return false;
    }

//    public static boolean hasCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        while (head != null) {
//            if (set.contains(head)) {
//                return true;
//            }
//            set.add(head);
//            head = head.next;
//        }
//        return false;
//    }
}
