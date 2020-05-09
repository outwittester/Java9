public class MyArray {
    private Object[] elementData;

    private int size;

    public MyArray() {
        this(10);
    }

    public MyArray(int initialCapacity) {
        if (initialCapacity < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData = new Object[initialCapacity];
    }

    public void add(Object obj) {
        // expand the capacity
        if (size == elementData.length) {
            Object[] newElementData = new Object[(size * 2) + 1];
            System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
            elementData = newElementData;
        }
        // assign first then increase
        elementData[size++] = obj;

    }


    public int getsize() {
        return size;
    }

    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    public void remove(int index) {
        rangeCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null; //last position becomes null
    }

    public void remove(Object o){
        for(int i=0;i<size;i++){
            if(get(i).equals(o)){
                remove(i);
            }
        }
    }

    public Object set(int index,Object obj){
        rangeCheck(index);
        Object oldValue = elementData[index];
        elementData[index] = obj;
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
    }

    public static void main(String[] args) {
        MyArray list = new MyArray(3);
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
    }
}