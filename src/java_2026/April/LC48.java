package java_2026.April;

public class LC48 {
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
        // list1 = [1,2,4]
        ListNode list1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(4)));

        // list2 = [1,3,4]
        ListNode list2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4)));

        // 합치기
        ListNode result = mergeTwoLists(list1, list2);

        // 출력
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print(" → ");
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // dummy = 시작점 (절대 움직이지 않음!)
        // 실제 값은 없고 체인의 시작을 잡아두는 역할
        ListNode dummy = new ListNode();

        // current = 현재 붙이는 위치 (계속 앞으로 이동!)
        ListNode current = dummy;

        // 둘 다 null이 아닐 때만 비교
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                // list1이 더 작으면 current 뒤에 list1 붙이기
                current.next = list1;
                list1 = list1.next; // list1 한칸 전진
            } else {
                // list2가 더 작거나 같으면 current 뒤에 list2 붙이기
                current.next = list2;
                list2 = list2.next; // list2 한칸 전진
            }
            // current도 한칸 전진
            current = current.next;
        }

        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next;
    }
}
