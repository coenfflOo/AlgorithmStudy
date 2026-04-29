package java_2026.April;

public class LC46 {
    static  class ListNode {
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
        // 1 → 2 → 3 → 4 → 5 생성
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        // 뒤집기
        ListNode result = reverseList(head);

        // 출력
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print(" → ");
            result = result.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
