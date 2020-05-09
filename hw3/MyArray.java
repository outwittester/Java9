public class MyArray {
    private Object[] elementData;
    private int size;
    public MyArray() {
        this(10);
    }

    public MyArray(int capacity) {
        if (capacity < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData = new Object[capacity];
    }

    public void add(Object obj) {
        if (size == elementData.length) {
            Object[] newElementData = new Object[(size * 2)];
            System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
            elementData = newElementData;
        }
        elementData[size++] = obj;
    }

    public int getSize() {
            return size;
    }

    public Object get (int index) {
        rangeCheck(index);
        return elementData[index];
    }

    public void removeLast() {
        elementData[--size] = null;

    }

    public void removeFirst() {
        rangeCheck(0);
        this.remove(0);
    }

    public void remove(int index) {
        rangeCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);

        }
        elementData[--size] = null;

    }

    public void remove(Object obj) {
        int i = 0;
        for (i = 0; i < size; i++) {
            if (get(i).equals(obj)) {
                remove(i);
            }
        }

    }

    public Object set(int index, Object obj) {
        rangeCheck(index);
        Object oldValue = elementData[index];
        elementData[index] = obj;
        return oldValue;
    }

    public void merge(MyArray addedArray) {
        Object[] newArray = new Object[size + addedArray.getSize()];

        for (int i = 0; i < this.size; i++) {
            newArray[i] = elementData[i];
        }

        for (int j = this.size, i = 0; i < addedArray.getSize(); j++, i++) {
            newArray[j] = addedArray.get(i);
        }

        elementData = newArray;
        size = this.size + addedArray.getSize();

    }

    private void rangeCheck(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void printList() {
        for (int i = 0; i < elementData.length; ++i) {
            System.out.print(elementData[i] + ";");
        }
        System.out.println();
    }

    public void printSize() {
        System.out.println(size);
    }

    public static void main(String[] args) {
        MyArray list = new MyArray(3);
        list.add("aaa");
        list.add("aab");
        list.add("aac");
        list.add("aad");
        list.add("aae");
        list.add("aaf");

        list.printList();

        list.set(2, "www");
        list.printList();
        list.printSize();

        list.remove(3);
        list.printList();
        list.printSize();

        list.removeFirst();
        list.printList();
        list.printSize();

        list.removeLast();
        list.printList();
        list.printSize();

        list.add("this");
        list.printList();
        list.printSize();

        MyArray a = new MyArray(3);
        a.add(1);
        a.add(2);
        a.add(3);
        list.merge(a);
        list.printList();
        list.printSize();

        list.remove("aae");
        list.remove("dasdwqd");
        list.printList();
        list.printSize();

        list.getSize();

    }


}
