import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayDeque<T> implements Iterable<T>, Deque<T>{
    private T[] items;
    private int firstIndex;
    private int lastIndex;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        firstIndex = 7;
        lastIndex = 0;
        //here I set firstindex to 7 because I can't set it to zero otherwise when I add first it will loop around and interfere with lastindex
        //I did addfirst from the back of the array
        size = 0;
    }

    @Override
    public Iterator<T> iterator(){
        return new ArrayDequeIterator();
    }

    public class ArrayDequeIterator implements Iterator<T> {
        int pos = 0;

        public ArrayDequeIterator(){
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos<size();
        }

        @Override
        public T next() {
            pos++;
            return get(pos-1);
        }
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object instanceof ArrayDeque o){
            if (o.size!=this.size) return false;
            int index = 0;
            for (int i=0; i<size; i++){
                if (!o.get(i).equals(this.get(i))) return false;
            }
            return true;
        }
        return false;
    }

    public String toString(){
        String val = "{";
        for (int i=0; i<size; i++){
            val+=this.get(i);
            val+=", ";
        }
        val = val.substring(0, val.length()-2);
        val+="}";
        return val;
    }

    public void addFirst(T item) {
        if (size == items.length) resizeUp(size * 2);
        items[firstIndex] = item;
        size++;
        firstIndex = (firstIndex-1)%items.length;
    }

    public void addLast(T item) {
        if (size == items.length) resizeUp(size * 2);
        items[lastIndex] = item;
        size++;
        lastIndex = (lastIndex+1) % items.length;
    }

    private void resizeUp(int length) {
        T[] arr = (T[]) new Object[length];
        for (int i = 0; i < size; i++) {
            arr[i] = items[(firstIndex + 1 + i) % items.length];
        }
        items = arr;
        firstIndex = length - 1;
        lastIndex = size;
    }

    public boolean contains(T x) {
        for (int i=0; i<size; i++){
            if (this.get(i).equals(x)) return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return items[(firstIndex+1+index) % items.length];
    }

    public T removeLast() {
        if (size == 0) return null;
        lastIndex = (lastIndex - 1 + items.length) % items.length;
        T removedItem = items[lastIndex];
        items[lastIndex] = null;
        size--;
        return removedItem;
    }


    public List<T> toList(){
        List<T> list = new ArrayList<>();
        for (int i=0; i<size(); i++){
            list.add(get(i));
        }
        return list;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(firstIndex+1+i) % items.length] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(1);
        arr.addFirst(2);
        Iterator<Integer> seer = arr.iterator();

        ArrayDeque<Integer> arr2 = new ArrayDeque<>();
        arr2.addFirst(2);
        arr2.addFirst(1);
        arr2.addFirst(2);
        arr2.addFirst(1);
        arr2.addLast(100);

        Comparator<Integer> dc = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };

        MaxArrayDeque<Integer> arr3 = new MaxArrayDeque<>();
        arr3.addFirst(1);
        arr3.addFirst(2);
        System.out.println(arr3.max(dc));
    }
}

