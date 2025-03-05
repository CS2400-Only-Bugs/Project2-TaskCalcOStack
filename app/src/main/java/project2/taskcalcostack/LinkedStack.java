package project2.taskcalcostack;

import java.util.EmptyStackException;

import org.w3c.dom.Node;

public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode;

    public LinkedStack() {
        topNode = null;
    }

    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }// end push

    public T pop() {
        T top = peek();
        if (topNode != null) {
            topNode = topNode.getNext();
        } else {
            throw new EmptyStackException();
        }
        return top;
    }// end pop

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return topNode.getData();
        }
    }// end peek

    public boolean isEmpty() {
        return topNode == null;
    }// end isEmpty

    public void clear() {
        topNode = null;
    }// end clear

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