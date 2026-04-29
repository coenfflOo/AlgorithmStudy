package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC49 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // [1,4,5]
        ListNode list1 = new ListNode(1,
                new ListNode(4,
                        new ListNode(5)));

        // [1,3,4]
        ListNode list2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4)));

        // [2,6]
        ListNode list3 = new ListNode(2,
                new ListNode(6));

        ListNode[] lists = {list1, list2, list3};

        ListNode result = mergeKLists(lists);

        // 출력
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print(" → ");
            result = result.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        // 값이 작은 노드가 앞에 오는 Min-heap
        // (a,b) -> a.val - b.val = 오름차순 정렬
        PriorityQueue<ListNode> que = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 각 리스트의 head를 힙에 추가
        // 처음엔 각 리스트의 첫번째 노드만 넣음
        for (ListNode node : lists) {
            if (node != null) que.add(node);
        }
        // 힙 상태: [1(list1), 1(list2), 2(list3)]

        ListNode dummy = new ListNode();
        ListNode res = dummy;

        while (!que.isEmpty()) {
            // 힙에서 가장 작은 노드 꺼내기
            ListNode curr = que.poll();

            // result 뒤에 붙이기
            res.next = curr;
            res = res.next;

            // 꺼낸 노드의 다음 노드를 힙에 추가
            // 해당 리스트의 다음 후보를 힙에 넣는 것!
            if (curr.next != null) {
                que.offer(curr.next);
            }
        }
        return dummy.next;
    }

//    public static ListNode mergeKLists(ListNode[] lists) {
//        ListNode result = null;
//        for (ListNode list : lists) {
//            result = mergeTwoLists(result, list);
//        }
//        return result;
//    }
//
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        ListNode dummy = new ListNode();
//        ListNode cur = dummy;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                cur.next = l1;
//                l1 = l1.next;
//            } else {
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        if (l1 != null) cur.next = l1;
//        if (l2 != null) cur.next = l2;
//        return dummy.next;
//    }
}
