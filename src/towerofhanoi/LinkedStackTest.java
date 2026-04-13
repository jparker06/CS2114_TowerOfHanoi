package towerofhanoi;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those
//who do.
//
//-- James Parker (jamesp28)

import java.util.EmptyStackException;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test class of the LinkedStack class.
 * 
 *  @author James Parker
 *  @version March 25, 2025
 */
public class LinkedStackTest extends TestCase {
    //~ Fields ................................................................
    private LinkedStack<String> stack;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Sets up the test class.
     */
    public void setUp() {
        stack = new LinkedStack<String>();
    }
    
    /**
     * Tests the clear() method.
     */
    public void testClear() {
        stack.push("item1");
        stack.push("item2");
        stack.push("item3");
        assertEquals(3, stack.size());
        stack.clear();
        assertEquals(0, stack.size());
    }
    
    /**
     * Tests the isEmpty() method.
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("item1");
        assertFalse(stack.isEmpty());
    }
    
    /**
     * Tests the peek() method.
     */
    public void testPeek() {
        // Empty stack
        Exception exception = null;
        try {
            stack.peek();
        }
        catch (EmptyStackException e) {
            exception = e;
        }
        assertNotNull(exception);
        
        // Stack with items
        stack.push("item1");
        stack.push("item2");
        assertEquals("item2", stack.peek());
        stack.pop();
        assertEquals("item1", stack.peek());
    }

    /**
     * Tests the pop() method.
     */
    public void testPop() {
        // Empty stack
        Exception exception = null;
        try {
            stack.pop();
        }
        catch (EmptyStackException e) {
            exception = e;
        }
        assertNotNull(exception);
        
        // Stack with items
        stack.push("item1");
        stack.push("item2");
        assertEquals(2, stack.size());
        assertEquals("item2", stack.pop());
        assertEquals("item1", stack.peek());
        assertEquals(1, stack.size());
    }

    /**
     * Tests the push() method.
     */
    public void testPush() {
        stack.push("item1");
        assertEquals("item1", stack.peek());
        assertEquals(1, stack.size());
    }

    /**
     * Tests the size() method.
     */
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push("item1");
        stack.push("item2");
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    /**
     * Tests the toString() method.
     */
    public void testToString() {
        assertEquals("[]", stack.toString());
        stack.push("item1");
        stack.push("item2");
        stack.push("item3");
        assertEquals("[item3, item2, item1]", stack.toString());
    }
}
