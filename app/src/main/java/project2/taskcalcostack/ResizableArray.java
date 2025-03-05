package project2.taskcalcostack;
import java.util.EmptyStackException;
/**
 * @author Jayden Briones
 * @version 1.0
 */
public final class ResizableArray<T> implements StackInterface<T> {
    private T[] stack;
    private int topIndex;
    private static final int DEFAULT_SIZE = 50;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;

    public ResizableArray(){
        this(DEFAULT_SIZE);
    } // end default constructor

    public ResizableArray(int initialCapacity){
        integrityOK = false;
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    } // end constructor

    public void push(T newEntry){
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }//end push

    private void ensureCapacity(){
        if(topIndex >= stack.length - 1){
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = java.util.Arrays.copyOf(stack, newLength);
        }//end if
    }//end ensureCapacity

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

    public T peek(){
        checkIntegrity();
        if(isEmpty()){
            throw new EmptyStackException();
        }else{
            return stack[topIndex];
        }//end if
    }//end peek

    public boolean isEmpty(){
        return topIndex < 0;
    }//end isEmpty

    public boolean checkIntegrity(){
        return integrityOK;
    }//end checkIntegrity

    public void clear(){
        checkIntegrity();
        while(topIndex > -1){
            stack[topIndex] = null;
            topIndex--;
        }//end while
    }//end clear

    public void checkCapacity(int capacity){
        if(capacity > MAX_CAPACITY){
            throw new IllegalStateException("Attempt to create a stack " +
                    "whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
        }//end if
    }//end checkCapacity
}
