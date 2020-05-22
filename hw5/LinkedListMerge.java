public class LinkedListMerge {
    public static void main(String[] args) {
        ListNode N1 = new ListNode(2);
        ListNode N2 = new ListNode(4);
        ListNode N3 = new ListNode(9);
        ListNode N4 = new ListNode(10);
        N1.next = N2;
        N2.next = N3;
        N3.next = N4;

        ListNode M1 = new ListNode(1);
        ListNode M2 = new ListNode(6);
        ListNode M3 = new ListNode(8);
        ListNode M4 = new ListNode(11);
        ListNode M5 = new ListNode(21);
        M1.next = M2;
        M2.next = M3;
        M3.next = M4;
        M4.next = M5;

        ListNode newl = Merge_List.mergeTwoLists(N1, M1);
        Merge_List.printList(newl);

     }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Merge_List{
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        return dummy;
    }

    public static void printList(ListNode l) {
        while (l.next != null) {
            System.out.println(l.next.val);
            l = l.next;
        }
    }
}