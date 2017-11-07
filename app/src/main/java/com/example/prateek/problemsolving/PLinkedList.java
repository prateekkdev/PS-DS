package com.example.prateek.problemsolving;

/**
 * Created by prateek on 6/11/17.
 */

public class PLinkedList<T> {

    private PNode head;
    private int size;

    public void add(T data) {
        addFirst(data);
    }

    public void addFirst(T data) {
        PNode node = new PNode(data);
        node.next = head;
        this.head = node;
        size++;
    }

    public void addLast(T data) {

        PNode dataNode = new PNode(data);

        if (head == null) {
            head = dataNode;
            return;
        }

        PNode node = head;

        while (node.next != null) {
            node = node.next;
        }

        node.next = dataNode;
    }

    void remove() {
        removeFirst();
    }

    void removeFirst() {

        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        head = head.next;
    }

    public void remove(T data) {

        if (head == null) {
            return;
        }

        if (head.next == null && head.data.equals(data)) {
            head = null;
            size--;
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }

        PNode node = head;

        while (node.next != null) {

            if (node.next.data.equals(data)) {
                node.next = node.next.next;
                size--;
                return;
            }

            node = node.next;
        }
    }

    void removeLast() {

        if (head == null) {
            return;
        }

        if (head.next == null) {
            size--;
            head = null;
        }

        PNode node = head;

        while (node.next.next != null) {
            node = node.next;
        }

        size--;
        node.next = null;

    }

    public T findFirst() {

        if (head == null) {
            return null;
        }

        return head.data;
    }

    public T findLast() {

        if (head == null) {
            return null;
        }

        PNode node = head;

        while (node.next != null) {
            node = node.next;
        }

        return node.data;
    }

    public T findAt(int index) {

        if (head == null) {
            return null;
        }

        int current = 1;

        PNode node = head;

        while (node.next != null && current < index) {
            node = node.next;
            current++;
        }

        if (current == index) {
            return node.data;
        }

        return null;
    }

    public boolean isData(T data) {

        if (head == null) {
            return false;
        }

        PNode node = head;

        while (node.next != null) {

            if (node.data.equals(data)) {
                return true;
            }

            node = node.next;
        }

        return false;
    }

    public int size() {
        return size;
    }

    private class PNode {

        private PNode next;
        private T data;

        public PNode(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object obj) {
            if (this.data == ((PNode) obj).data) {
                return true;
            }
            return false;
        }
    }
}