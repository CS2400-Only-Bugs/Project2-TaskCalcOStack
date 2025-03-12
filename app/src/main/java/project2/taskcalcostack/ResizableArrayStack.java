package project2.taskcalcostack;
import java.util.EmptyStackException;
/**
 * @author Jayden Briones
 * @version 1.0
 */
public final class ResizableArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int topIndex;
    private static final int DEFAULT_SIZE = 50;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;

    /**
     * Creates an empty stack of 50
     */
    public ResizableArrayStack(){
        this(DEFAULT_SIZE);
    } // end default constructor

    /**
     * Creates a stack with a set capacity
     * @param initialCapacity is the set capacity
     */
    public ResizableArrayStack(int initialCapacity){
        integrityOK = false;
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    } // end constructor

    /**
     * Adds a new entry to the top of the stack
     * @param newEntry is the added entry
     */
    @Override
    public void push(T newEntry){
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }//end push

    /**
     * Doubles the length of the stack if full
     */
    private void ensureCapacity(){
        if(topIndex >= stack.length -1){
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = java.util.Arrays.copyOf(stack, newLength);
        }//end if
    }//end ensureCapacity

    /**
     * Removes the top entry from the stack
     * @return the new top entry from the stack
     */
    @Override
    public T pop(){
        checkIntegrity();
        if(isEmpty()){
            throw new EmptyStackException();
        }else{
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }//end if
    }//end pop

    /**
     * @return the top entry of the stack
     */
    @Override
    public T peek(){
        checkIntegrity();
        if(isEmpty()){
            throw new EmptyStackException();
        }else{
            return stack[topIndex];
        }//end if
    }//end peek

    /**
     * @return if the stack is empty
     */
    @Override
    public boolean isEmpty(){
        return topIndex < 0;
    }//end isEmpty

    /**
     * @return if integrityOK
     */
    public boolean checkIntegrity(){
        return integrityOK;
    }//end checkIntegrity

    /**
     * Clears stack
     */
    @Override
    public void clear(){
        checkIntegrity();
        while(topIndex > -1){
            stack[topIndex] = null;
            topIndex--;
        }//end while
    }//end clear

    /**
     * Checks if the set capacity is too large
     * @param capacity is the set capacity
     */
    public void checkCapacity(int capacity){
        if(capacity > MAX_CAPACITY){
            throw new IllegalStateException("Attempt to create a stack " +
                    "whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
        }//end if
    }//end checkCapacity
}
