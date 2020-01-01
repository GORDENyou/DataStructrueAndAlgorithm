package _004LinkedList;

public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){
        Node node = new Node(e);
        node.next = head;
        head = node;

        //优雅写法：
        //head =  new Node(e, head);
        size++;
    }

    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("The index is too big!");

        if(index == 0){
            addFirst(e);
        }else{
            Node prev = head;
            while(index - 1 > 0){
                prev = prev.next;
                index--;
            }

            prev.next = new Node(e, prev.next);
        }

        size++;
    }

    public void addLast(E e){
        add(size, e);
    }
}
