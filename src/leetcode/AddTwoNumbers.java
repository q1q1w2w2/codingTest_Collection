package leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers clazz = new AddTwoNumbers();
        int[] l1Array = {2, 4, 3};
        int[] l2Array = {5, 6, 4};

//        ListNode l1 = new ListNode(l1Array[0]);
//        l1.next = new ListNode(l1Array[1]);
//        l1.next.next = new ListNode(l1Array[2]);

        ListNode l1 = new ListNode(l1Array[0]);
        ListNode current1 = l1;
        for (int i = 1; i < l1Array.length; i++) {
            current1.next = new ListNode(l1Array[i]);
            current1 = current1.next;
        }

        ListNode l2 = new ListNode(l2Array[0]);
        ListNode current2 = l2;
        for (int i = 1; i < l2Array.length; i++) {
            current2.next = new ListNode(l2Array[i]);
            current2 = current2.next;
        }

        ListNode result = clazz.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
        System.out.println();
    }

    /**
     * 비어 있지 않은 두 개의 연결 리스트가 주어짐
     * [2,4,3] [5,6,4]
     * 342+465=807
     * [7,0,8] 반환
     *
     * 2 -> 4 -> 3
     * 5 -> 6 -> 4
     *
     * 7 -> 0 -> 8
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
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
            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = curr.next;
        }
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
