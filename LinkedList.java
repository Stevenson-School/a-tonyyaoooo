public class LinkedList<T> {
    Node pre;
    Node back;
    int size;
    public class Node{
        T item;
        Node next;
       public Node(T x){
           item = x;
       }
    }

    public LinkedList(T x){
        pre = null;
        back = null;
        size=0;
    }

    public void addFirst(T x){
        Node temp = new Node(x);
        if (isEmpty()) {
            pre = next = temp;
        }
        temp.next = pre;
        pre = temp;
        size++;
    }

    public void addLast(T x){
        Node newNode = new Node(x);
        if (isEmpty()){
            pre = back =  newNode;
        }
        newNode.next = back;
        back = newNode;
        size++;
    }
}
