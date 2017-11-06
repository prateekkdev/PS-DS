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
            }

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

    public int size() {
        return size;
    }

    private class PNode {

        private PNode next;
        private T data;

        public PNode(T data) {
            this.data = data;
        }

        public PNode next() {
            return next;
        }

        public T data() {
            return data;
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