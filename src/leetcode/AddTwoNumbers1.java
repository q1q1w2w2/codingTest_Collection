package leetcode;

public class AddTwoNumbers1 {
    public static void main(String[] args) {
        int[] l1Arr = {2, 4, 3};
        int[] l2Arr = {5, 6, 4};

        ListNode l1 = new ListNode(l1Arr[0]);
        ListNode current1 = l1;
        for (int i = 1; i < l1Arr.length; i++) {
            current1.next = new ListNode(l1Arr[i]);
            current1 = current1.next;
        }

        ListNode l2 = new ListNode(l2Arr[0]);
        ListNode current2 = l2;
        for (int i = 1; i < l2Arr.length; i++) {
            current2.next = new ListNode(l2Arr[i]);
            current2 = current2.next;
        }

        ListNode listNode = addTwoNumbers(l1, l2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry; // 올림수 더하기
            carry = sum / 10; // 올림수 수정
            ListNode node = new ListNode(sum % 10);
            current.next = node; // 얘는 연결해준거고
            current = current.next; // 얘는 위치 최신화
        } // 0 -> 7 -> 0 -> 8
        return dummy.next;
    }

    public static class ListNode {
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
}