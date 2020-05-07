import java.util.Arrays;

public class SelfArrayList {
    private int capacity;
    private Object[] data;
    private int size = 0;

    public SelfArrayList(){
        this(10);
    }

    public SelfArrayList(int capacity) {
        if (capacity < 0) this.capacity = 10;
        else this.capacity = capacity;
        data = new Object[this.capacity];
    }

    public void add(Object o) {
        if (size < this.capacity) {
            data[size] = o;
            size++;
        }
        else {
            Object[] tmp = Arrays.copyOfRange(this.data, 0, 2*this.capacity+1); //+1 防止capacity是0
            data = tmp;
            data[size] = o;
            size++;
        }
    }

    public Object get(int idx) {
        if (idx >= size) return null;
        return data[idx];
    }

    public int get(Object o) {
        int i = 0;
        if (size == 0) return -1;
        while (i < size) {
            if (data[i].equals(o)) return i;
        }
        return -1;
    }

    public void set(int idx, Object o) {
        if (idx >= size) return;
        this.data[idx] = o;
    }

    public void remove(Object o) {
        int i = 0;
        if (size == 0) return;
        int removeIdx = 0;
        while (i < size) {
            if (data[i].equals(o)) {
                removeIdx = i;
            }
        }

        for (int j = removeIdx; j < size-1; j++) {
            data[j] = data[j+1];
        }
        data[size-1] = null;
        size--;
    }

    public void remove(int idx) {
        if (idx >= size) return;
        int i = idx;
        while (i < size-1) {
            data[i] = data[i+1];
            i++;
        }
        data[size-1] = null;
        size--;
    }

    public int getsize() {
        return size;
    }

    public static void main(String[] args) {
        SelfArrayList list = new SelfArrayList(3);
        list.add("aaa");
        list.add("aab");
        list.add("aac");
        list.add("aad");
        list.add("aae");
        list.add("aaf");

        System.out.println(list.get(2));
        list.set(2, "www");
        System.out.println(list.get(2));
        System.out.println(list.getsize());
        for (int i = 0; i < list.getsize(); i++) {
            System.out.print(list.get(i) + "  ");
        }
        System.out.println("\n===================");
        list.remove(3);
        for (int i = 0; i < list.getsize(); i++) {
            System.out.print(list.get(i) + "  ");
        }
    }
}
