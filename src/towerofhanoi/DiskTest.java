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
 *  Test class for the Disk class.
 * 
 *  @author James Parker
 *  @version March 25, 2025
 */
public class DiskTest extends TestCase {
    //~ Fields ................................................................
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Sets up the test class.
     */
    public void setUp() {
        disk1 = new Disk(5);
        disk2 = new Disk(3);
        disk3 = new Disk(7);
    }
    
    /**
     * Tests the compareTo() method.
     */
    public void testCompareTo() {
        Disk newDisk = null;
        Exception exception = null;
        try {
            disk1.compareTo(newDisk);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);
        
        assertEquals(1, disk1.compareTo(disk2));
        assertEquals(-1, disk1.compareTo(disk3));
        newDisk = new Disk(5);
        assertEquals(0, disk1.compareTo(newDisk));
    }
    
    /**
     * Tests the toString() method.
     */
    public void testToString() {
        assertEquals("5", disk1.toString());
        assertEquals("3", disk2.toString());
        assertEquals("7", disk3.toString());
    }
    
    /**
     * Tests the equals() method.
     */
    public void testEquals() {
        // Disks are identical
        Disk newDisk = disk1;
        assertTrue(disk1.equals(newDisk));
        
        // obj is null
        newDisk = null;
        assertFalse(disk1.equals(newDisk));
        
        // Different class
        assertFalse(disk1.equals(new Object()));
        
        // Same class and equal
        newDisk = new Disk(5);
        assertTrue(disk1.equals(newDisk));
        
        // Same class and different
        assertFalse(disk1.equals(disk2));
    }
}
