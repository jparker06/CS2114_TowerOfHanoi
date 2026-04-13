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
 *  Test class for the HanoiSolver class.
 * 
 *  @author James Parker
 *  @version March 25, 2025
 */
public class HanoiSolverTest extends TestCase {
    //~ Fields ................................................................
    private HanoiSolver hanoi;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Sets up the test class.
     */
    public void setUp() {
        hanoi = new HanoiSolver(3);
    }

    /**
     * Tests the disks() method.
     */
    public void testDisks() {
        assertEquals(3, hanoi.disks());
        hanoi = new HanoiSolver(4);
        assertEquals(4, hanoi.disks());
    }

    /**
     * Tests the getTower() method.
     */
    public void testGetTower() {
        Tower first = hanoi.getTower(Position.LEFT);
        Tower middle = hanoi.getTower(Position.CENTER);
        Tower last = hanoi.getTower(Position.RIGHT);
        Tower def = hanoi.getTower(Position.DEFAULT);
        assertEquals(middle, def);
        assertEquals("[]", first.toString());
    }

    /**
     * Tests the solve() method.
     */
    public void testSolve() {
        Tower begin = hanoi.getTower(Position.LEFT);
        begin.push(new Disk(5));
        begin.push(new Disk(4));
        begin.push(new Disk(3));
        Tower center = hanoi.getTower(Position.CENTER);
        Tower end = hanoi.getTower(Position.RIGHT);
        assertEquals(3, begin.size());
        assertEquals(0, center.size());
        assertEquals(0, end.size());
        hanoi.solve();
        assertEquals(0, begin.size());
        assertEquals(0, center.size());
        assertEquals(3, end.size());
    }
    
    /**
     * Tests the toString() method.
     */
    public void testToString() {
        Tower begin = hanoi.getTower(Position.LEFT);
        assertEquals("[][][]", hanoi.toString());
        begin.push(new Disk(5));
        begin.push(new Disk(4));
        begin.push(new Disk(3));
        assertEquals("[3, 4, 5][][]", hanoi.toString());
    }
}
