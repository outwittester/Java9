// Singly LinkedList implementation
// using the dummy node to avoid special case of the head
// need to take care of the tail

class ListNode {
    Object obj;
    //ListNode prev;
    ListNode next;
    public ListNode(){
        this(null);
    }
    public ListNode(Object o) {
        this.obj = o;
        //this.prev = null;
        this.next = null;
    }
}
public class SelfLinkedList {
    private ListNode dummy;
    private ListNode tail;
    public SelfLinkedList(){
        dummy = new ListNode(0);
        tail = dummy;
    }

    public void add(Object o) {
        ListNode node = new ListNode(o);
        tail.next = node;
        tail = node;
    }

    public Object get(int idx) {
        ListNode p = dummy.next;
        int pIdx = 0;
        while (p != null) {
            if (pIdx == idx) return p.obj;
            p = p.next;
            pIdx++;
        }
        return null;
    }

    public Object getNext(Object o) {
        if (o == null) return null;
        ListNode p = dummy.next;
        while (p != null) {
            if (p.obj.equals(o)) {
                return p.next.obj;
            }
        }
        return null;
    }

    public Object getPrev(Object o) {
        ListNode p = dummy.next;
        if (p.equals(o)) return null;
        while (p.next != null) {
            if (p.next.obj.equals(o)) {
                return p.obj;
            }
            p = p.next;
        }
        return null;
    }

    public void remove(int idx) {
        ListNode p = dummy.next;
        ListNode prevNode = dummy;
        if (dummy.next == null) return;

        ListNode nextNode = p.next;
        int pIdx = 0;
        while(nextNode != null) {
            if (pIdx == idx) {
                prevNode.next = nextNode;
                return;
            }
            pIdx++;
            prevNode = prevNode.next;
            p = p.next;
            nextNode = nextNode.next;
        }

        // o is tail
        if (pIdx == idx) {
            prevNode.next = null;
            tail = prevNode;
        }
    }

    public void remove(Object o) {
        ListNode p = dummy.next;
        ListNode prevNode = dummy;
        if (dummy.next == null) return;

        ListNode nextNode = p.next;

        while (nextNode != null) {
            if (p.obj.equals(o)) {
                prevNode.next = nextNode;
                return;
            }
            prevNode = prevNode.next;
            p = p.next;
            nextNode = nextNode.next;
        }
        // o is the tail
        if (p.obj.equals(o)) {
            prevNode.next = null;
            tail = prevNode;
        }
    }

    public int getSize() {
        int count = 0;
        ListNode p = dummy.next;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public void insert(int idx, Object o) {
        ListNode p = dummy.next;
        int pIdx = 0;
        ListNode node = new ListNode(o);

        if (dummy.next == null && idx == 0) {
            dummy.next = node;
        }

        if (dummy.next == null && idx != 0) return;

        ListNode prevNode = dummy;
        ListNode nextNode = dummy.next.next;
        while (nextNode != null) {
            if (pIdx == idx) {
                prevNode.next = node;
                node.next = p;
                return;
            }
            p = p.next;
            pIdx++;
            prevNode = prevNode.next;
            nextNode = nextNode.next;
        }

        //insert to the tail
        if (pIdx == idx) {
            prevNode.next = node;
            node.next = p;
            tail = p;
        }
    }

    public void printList() {
        ListNode p = dummy.next;
        System.out.println("===========");
        while (p != null) {
            System.out.print(p.obj + " ");
            p = p.next;
        }
        System.out.println("\n===========");
    }

    public static void main(String[] args) {
        SelfLinkedList list = new SelfLinkedList();
        list.add("aaa");
        list.add("bbb");
        //list.insert(1, "BBB");
        list.add("ccc");
        list.printList();

        list.insert(1, "BBB");
        list.printList();

        System.out.println(list.getSize());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        list.remove(1);
        list.printList();

        System.out.println(list.getSize());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
