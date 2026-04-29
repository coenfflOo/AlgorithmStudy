package java_2026.April;

import java.util.*;
import java.io.*;
import java.lang.*;

public class LC50 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // [1,2,3,4,5]
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        int n = 2;

        ListNode result = removeNthFromEnd(head, n);

        // 출력
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print(" → ");
            result = result.next;
        }
        System.out.println();

        head = new ListNode(1);

        n = 1;

        result = removeNthFromEnd(head, n);

        // 출력
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print(" → ");
            result = result.next;
        }
        System.out.println();


        head = new ListNode(1, new ListNode(2));

        result = removeNthFromEnd(head, n);

        // 출력
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print(" → ");
            result = result.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // dummy 노드 생성 후 head에 연결
        // head 자체를 삭제해야 할 때도 처리 가능!
        // ex) [1,2], n=2 → 1 삭제할 때 dummy가 앞에서 잡아줌
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // slow = 삭제할 노드의 바로 앞까지 이동
        // fast = slow보다 n+1칸 앞에서 이동
        ListNode slow = dummy;
        ListNode fast = dummy;

        // fast를 n+1칸 먼저 이동
        // n+1칸인 이유 = slow가 삭제할 노드의 "바로 앞"에 있어야 하니까!
        while (n-- >= 0) {
            fast = fast.next;
        }

        // slow와 fast 같이 이동
        // fast가 null이 되면 slow는 삭제할 노드 바로 앞!
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow.next = 삭제할 노드
        // slow.next.next = 삭제할 노드의 다음 노드
        // 연결을 건너뛰어서 삭제!
        slow.next = slow.next.next;

        return dummy.next;
    }
}
