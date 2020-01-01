package _003Queue;

import java.util.NoSuchElementException;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        //当我们的队列已经满了时候，我们要扩容
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;//正式插入数据
        tail = (tail + 1) % data.length; //由于是循环队列，需要保证我们的尾节点在正确的位置上。
        size++;
    }

    /**
     * 这里动态拓展队列，步骤需要好好理解。
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new NoSuchElementException("Cannot dequeue from an empty queue!");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        //这里要注意我们缩容时的条件判断。
        if(size == getCapacity() % 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2 );

        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty!");
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder(String.format
                ("Queue Size is %d, the Capacity is %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for(int i = 0;i < 10; i++){
            loopQueue.enqueue(i);
            System.out.println(loopQueue);

            if(i % 3 == 2){
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }
}
