package _004LinkedList;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;//有头结点            //private Node head;//无头结点
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);         //head = null;
        /**
         * 带头节点和不带头结点有什么区别？
         * 从实现来说，head没有进行实例化，head引用的是第一个节点。
         * 而dummyHead 进行了实例化，next指向了第一个节点。
         */
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

//    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//
//        //优雅写法：
//        //head =  new Node(e, head);
//        size++;
//    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("The index is too big!");

        Node prev = dummyHead;
        while (index > 0) {
            prev = prev.next;
            index--;
        }

        prev.next = new Node(e, prev.next);

        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    //获取最后一个元素
    //todo

    //修改连标点的index（0-based）个位置的元素为e
    //todo

    //查找链表中是否有元素e
    //todo
    public boolean contains(E e){
        return false;
    }

    //从链表中删除index(0-based)位置的元素，返回删除的元素
    //todo
    public E remove(int index){
        return null;
    }

    //删除第一个//todo
    public void removeFirst(){

    }

    //删除最后一个//todo
    public void removeLast(){

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
