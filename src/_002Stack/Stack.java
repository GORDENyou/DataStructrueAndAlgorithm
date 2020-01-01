package _002Stack;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();//弹出栈顶元素
    E peek();//查看栈顶元素
}
