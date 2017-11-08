package com.example.prateek.problemsolving;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by prateek on 7/11/17.
 */

public class PStack<T> {

    public static final int SIZE_DEFAULT = 10;

    private int currentSize;

    /**
     * Object, not T because we cannot have array of generic type.
     */
    private Object[] arr;

    public PStack() {
        arr = new Object[SIZE_DEFAULT];
    }

    public PStack(int size) {
        arr = new Object[size];
    }

    public void push(T data) {

        if (currentSize == arr.length) {
            increaseSize();
        }

        arr[currentSize++] = data;
    }

    /**
     * Deep copy is not required, as we could utilize the same objects.
     * Only the array size needs to increase.
     * <p>
     * This has complexity of O(n)
     */
    private void increaseSize() {

        Object[] newArr = new Object[arr.length * 2];

        for (int index = 0; index < arr.length; index++) {
            newArr[index] = arr[index];
        }

        arr = newArr;
    }

    /**
     * Typecasting is needed, because T is subset of Object.
     *
     * @return
     */
    public T pop() {
        if (!isEmpty()) {
            return (T) arr[--currentSize];
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return (T) arr[currentSize - 1];
        }
        return null;
    }

    public boolean isEmpty() {
        if (currentSize == 0) {
            return true;
        }
        return false;
    }

    public T get(int index) {

        if (index > currentSize - 1) {
            return null;
        }

        return (T) arr[index];
    }

    public boolean contains(T data) {
        if (search(data) != -1) {
            return true;
        }

        return false;
    }

    public int search(T data) {

        for (int index = 0; index < currentSize; index++) {

            if (arr[index].equals(data)) {
                return index;
            }

        }

        return -1;
    }
}