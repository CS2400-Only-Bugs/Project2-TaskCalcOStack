package project2.taskcalcostack;

import org.w3c.dom.Node;

public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode;

    public LinkedStack() {
        topNode = null;
    }

    public void push(T newEntry) {

    }

    public T pop() {
        T result = null;
        return result;
    }

    public T peek() {
        T result = null;
        return result;
    }

    public boolean isEmpty() {
        boolean result = false;
        return result;
    }

    public void clear() {

    }

    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this(data, null);
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }
    }
}