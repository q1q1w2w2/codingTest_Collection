package leetcode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(1, l2); // 1 -> 2 -> 4

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(3, l4);
        ListNode l6 = new ListNode(1, l5);

        System.out.println(mergeTwoLists(l3, l6));
    }

    /**
     * 정렬된 두 노드를 받아서 정렬하면서 합치기
     * 1 2 4 / 1 3 4 / 1 1 2 3 4 4
     * 1 2 3 / 4 5 6 / 1 2 3 4 5 6
     *
     * 1. l1.val <= l2.val 이면, l1.val 저장
     * 2. l1.val > l2.val 이면, l2.val 저장
     *
     * 근데 l1 l2는 리스트에서 젤 큰 수인데
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode last = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                last.next = l1;
                l1 = l1.next;
            } else {
                last.next = l2;
                l2 = l2.next;
            }
            last = last.next;
        }

        if (l1 == null) {
            last.next = l2;
        } else {
            last.next = l1;
        }

        return preHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
