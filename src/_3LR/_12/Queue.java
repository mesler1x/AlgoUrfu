package _3LR._12;


public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front = 0;
    private int rear = -1;
    private int countItems = 0;

    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
    }

    public void add(int value) {
        if (rear == maxSize - 1)
            rear = -1;
        queueArray[++rear] = value;
        countItems++;
    }

    public int remove() {
        int temp = queueArray[front++];
        if (front == maxSize)
            front = 0;
        countItems--;
        return temp;
    }

    public boolean isEmpty() {
        return countItems == 0;
    }

    public boolean isFull() {
        return countItems == maxSize;
    }

    public int size() {
        return countItems;
    }
}