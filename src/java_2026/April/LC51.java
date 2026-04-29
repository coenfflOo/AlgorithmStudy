package java_2026.April;

public class LC51 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // [1,2,3,4]
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));

        reorderList(head);

        // 출력
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" → ");
            head = head.next;
        }

        head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        reorderList(head);

        // 출력
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" → ");
            head = head.next;
        }
    }

    public static void reorderList(ListNode head) {
        // fast가 2칸씩 이동하고 slow가 1칸씩 이동하면
        // fast가 끝에 도달할 때 slow는 항상 중간에 있어요!
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode back = slow.next;
        ListNode prev = null;
        while (back != null) {
            ListNode next = back.next;
            back.next = prev;
            prev = back;
            back = next;
        }
        slow.next = null;

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head != null && prev != null) {
            cur.next = head;
            cur = cur.next;
            head = head.next;
            cur.next = prev;
            prev = prev.next;
            cur = cur.next;
        }
        if (head != null) cur.next = head;
        else cur.next = prev;
    }
}
