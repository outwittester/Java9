public class MergeTwoLinkedList {
    public static void main(String[] args) {
        ListNodeM l1 = new ListNodeM(1);
        ListNodeM p = l1;
        p.next = new ListNodeM(2);
        p = p.next;
        p.next = new ListNodeM(4);
        printLinkedList(l1);

        ListNodeM l2 = new ListNodeM(1);
        p = l2;
        p.next = new ListNodeM(3);
        p = p.next;
        p.next = new ListNodeM(4);
        printLinkedList(l2);

        ListNodeM l3 = mergeList(l1, l2);
        printLinkedList(l3);

    }

    public static ListNodeM mergeList(ListNodeM l1, ListNodeM l2) {
        if (l1 == null || l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNodeM dummy = new ListNodeM();
        ListNodeM p1 = l1;
        ListNodeM p2 = l2;
        ListNodeM p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            }
            else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }

        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }

    public static void printLinkedList(ListNodeM l) {
        if (l == null) return;
        ListNodeM p = l;
        while (p != null) {
            System.out.print(p.val+"\t");
            p = p.next;
        }
        System.out.println();
    }
}

class ListNodeM {
    int val = 0;
    ListNodeM next = null;
    public ListNodeM(int val, ListNodeM next){
        this.val = val;
        this.next = next;
    }
    public ListNodeM(int val) {
        this.val = val;
    }
    public ListNodeM() {}
}
