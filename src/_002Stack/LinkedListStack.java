package _002Stack;

import _004LinkedList.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>(); //没有容积的概念，本来就是动态增加的。
    }

    @Override
    public int getSize() {
        return list.getSize();
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);

        return res.toString();
    }
}
