package towerofhanoi;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those
//who do.
//
//-- James Parker (jamesp28)

import stack.StackInterface;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 *  A stack made of linked Nodes.
 *  
 * 
 *  @author mrfan
 *  @version Mar 20, 2025
 *  @param <T> - The type of object in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
    //~ Fields ................................................................
    private int size; // The number of items in the stack
    private Node topNode; // The item on the top of the stack

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Create a new LinkedStack object.
     */
    public LinkedStack() {
        size = 0;
        topNode = null;
    }
    
    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T removedItem = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return removedItem;
    }

    @Override
    public void push(T anEntry) {
        Node newNode = new Node(anEntry, topNode);
        topNode = newNode;
        size++;
    }
    
    /**
     * Gets the number of items in the stack.
     * @return The number of items in the stack
     */
    public int size() {
        return size;
    }
    
    /**
     * Prints a String of the contents of the stack.
     * 
     * @return The new String
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        Node currNode = topNode;
        int num = size;
        str.append("[");
        while (num > 1) {
            str.append(currNode.getData());
            str.append(", ");
            currNode = currNode.getNextNode();
            num--;
        }
        str.append(currNode.getData());
        str.append("]");
        return str.toString();
        
    }
    
    private class Node {
        private T data;
        private Node next;
        
        
        
        public Node(T data) {
            this(data, null);
        }
        
        public Node(T data, Node next) {
            this.data = data;
            setNextNode(next);
        }
        
        
        
        public T getData() {
            return data;
        }
        
        public Node getNextNode() {
            return next;
        }
        
        public void setNextNode(Node newNext) {
            next = newNext;
        }
    }
}
