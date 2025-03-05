package project2.taskcalcostack;

import java.util.EmptyStackException;

import org.w3c.dom.Node;

public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode;

    /** Creates an empty Stack */
    public LinkedStack() {
        topNode = null;
    }// end LinkedStack constructor

    /**
     * Adds a new entry to the top of a stack
     * 
     * @param newEntry the object to be added as a new entry
     */
    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }// end push

    /**
     * Removes the top entry to the stack
     * 
     * @return the removed entry from the stack
     */
    public T pop() {
        T top = peek();
        if (topNode != null) {
            topNode = topNode.getNext();
        } else {
            throw new EmptyStackException();
        }
        return top;
    }// end pop

    /**
     * Views the top entry of the stack
     * 
     * @return the viewed top entry of the stack
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return topNode.getData();
        }
    }// end peek

    /** @return true if the stack is empty, false otherwise */
    public boolean isEmpty() {
        return topNode == null;
    }// end isEmpty

    /** Clears the stack */
    public void clear() {
        topNode = null;
    }// end clear

    /**
     * Constructors for Node
     * 
     * @return the data and next node
     * @param data the data to be stored
     * @param next the next node
     */
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