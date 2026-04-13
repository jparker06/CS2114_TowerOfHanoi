package towerofhanoi;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those
//who do.
//
//-- James Parker (jamesp28)

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test class for the Tower class.
 * 
 *  @author James Parker
 *  @version March 25, 2025
 */
public class TowerTest extends TestCase {
    //~ Fields ................................................................
    private Tower tower;
    private Disk disk1;
    private Disk disk2;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Sets up the test class.
     */
    public void setUp() {
        tower = new Tower(Position.LEFT);
        disk1 = new Disk(5);
        disk2 = new Disk(10);
    }

    /**
     * Tests the position() method.
     */
    public void testPosition() {
        assertEquals(Position.LEFT, tower.position());
    }
    
    /**
     * Tests the push() method.
     */
    public void testPush() {
        // Disk is null
        Disk disk3 = null;
        Exception exception1 = null;
        try {
            tower.push(disk3);
        }
        catch (IllegalArgumentException e) {
            exception1 = e;
        }
        assertNotNull(exception1);
        
        // Empty stack
        tower.push(disk2);
        assertEquals(disk2, tower.peek());
        
        // Disk is smaller than the one on the stack
        tower.push(disk1);
        assertEquals(disk1, tower.peek());
        
        // Disk is larger than or equal to the one on the stack
        Exception exception2 = null;
        try {
            tower.push(disk2);
        }
        catch (IllegalStateException e) {
            exception2 = e;
        }
        assertNotNull(exception2);
    }
}
