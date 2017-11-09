package com.example.prateek.problemsolving;

/**
 * Created by prateek on 7/11/17.
 */

public class PQueue<T> {

    public static final int DEFAULT_CAPACITY = 10;

    private Object[] arr;

    // From here items would be added.
    private int front = -1;

    // From here items would be deleted.
    private int rear = -1;

    public PQueue() {
        arr = new Object[DEFAULT_CAPACITY];
    }

    public PQueue(int size) {
        arr = new Object[size];
    }

    public void enqueue(T data) {

        if (isEmpty()) {
            rear = 0;
            front = 0;
        } else if (isFull()) {
            increaseSize();
        } else if (front == arr.length - 1) {
            // If rear is at 0(that means full), this would already be taken care of in isFull above.
            front = 0;
        } else {
            front++;
        }

        arr[front] = data;
    }

    private void increaseSize() {
        throw new RuntimeException("Implement increseSize");
    }

    public T dequeue() {

        if (isEmpty()) {
            return null;
        }

        T data = (T) arr[rear];

        // If only element.
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        // If rear is at last element, need to assign it to first, after dequeue.
        else if (rear == arr.length - 1) {
            rear = 0;
        }
        // Normal case, no edge or only element.
        else {
            rear = rear + 1;
        }

        return data;
    }

    public T peek() {
        if (!isEmpty()) {
            return (T) arr[rear];
        }

        return null;
    }

    public boolean isEmpty() {

        if (front == -1 && rear == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {

        if (rear == 0 && front == arr.length - 1) {
            return true;
        }

        if (front == rear - 1) {
            return true;
        }

        return false;
    }
}