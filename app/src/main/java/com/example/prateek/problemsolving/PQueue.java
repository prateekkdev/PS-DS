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
            front = 0;
            rear = 0;
        }

        if (isFull()) {
            increaseSize();
        }

        arr[front++] = data;
    }

    private void increaseSize() {

    }

    public T dequeue() {
        if (!isEmpty()) {
            return (T) arr[rear++];
        }

        return null;
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

        return false;
    }
}