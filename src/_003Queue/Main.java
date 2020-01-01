package _003Queue;

import java.util.Random;

/**
 * 用来大概的比较普通队列和循环队列的性能。
 */
public class Main {

    public static double testQueue(Queue<Integer> queue, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0; i < opCount; i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for(int i = 0; i < opCount; i++){
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayCost = testQueue(arrayQueue, 100000);
        System.out.println("ArrayQueue cost time is:" + arrayCost);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopCost = testQueue(loopQueue, 100000);
        System.out.println("ArrayQueue cost time is:" + loopCost);
    }
}
