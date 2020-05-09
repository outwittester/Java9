public class SelfDefinedArrayList {
    private Object[] data;
    private int size;

    public SelfDefinedArrayList(){
        this(10);
    }

    public SelfDefinedArrayList(int initSize){
        if(initSize < 0){
            try {
                throw new Exception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        data = new Object[initSize];
    }

    public int getSize(){
        return size;
    }

    public Object get(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public void add(Object obj){
        if(size == data.length){
            Object[] newElementData = new Object[(size + size/2)];
            System.arraycopy(data, 0, newElementData, 0, data.length);
            data = newElementData;
        }
        data[size++] = obj;
    }

    public void remove(Object obj){
        for(int i = 0; i < size; i++){
            if(get(i).equals(obj)){
                remove(i);
            }
        }
    }

    public void remove(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
    }

    public Object set(int index,Object obj){
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        Object val = data[index];
        data[index] = obj;
        return val;
    }


    public static void main(String[] args) {
        SelfDefinedArrayList list1 = new SelfDefinedArrayList(3);
        SelfDefinedArrayList list2 = new SelfDefinedArrayList(3);
        System.out.println(list1.equals(list2));
        System.out.println("size is: " + list1.getSize());
        list1.add("abc");
        list1.add("def");
        System.out.println("size is: " + list1.data.length);
        System.out.println("size is: " + list1.getSize());
        System.out.println(list1.get(1));
        list1.remove(list1.get(1));
        list1.add("ghi");
        System.out.println(list1.get(1));

        list1.add("def");
        list1.add("def");
        System.out.println(list1.get(0));
        System.out.println("size is: " + list1.data.length);
        System.out.println("size is: " + list1.getSize());
        System.out.println(list1.get(1));

        System.out.println("set the content '" + list1.set(1,"ended") + ("' to new content: ") + list1.get(1));
    }
}
